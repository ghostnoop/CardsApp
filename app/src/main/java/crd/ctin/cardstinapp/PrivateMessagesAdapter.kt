package crd.ctin.cardstinapp

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_chat.view.*
import kotlinx.android.synthetic.main.item_chat.view.message
import kotlinx.android.synthetic.main.private_messages_view.view.*

class PrivateMessagesAdapter (private val messagesList: List<Message>, private val listener: (Int) -> Unit):
        RecyclerView.Adapter<PrivateMessagesAdapter.ChatModelViewHolder>(){


    class ChatModelViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        @SuppressLint("SetTextI18n", "ResourceAsColor", "UseCompatLoadingForDrawables",
            "RtlHardcoded"
        )
        fun bind(message: Message, listener: (Int) -> Unit) = with(itemView) {
            itemView.message.text = message.msg
            if(message.name == "me"){
                itemView.chat_container.background = resources.getDrawable(R.drawable.chat_bg_right)
                itemView.chat_view_global_container.gravity = Gravity.RIGHT
            } else{
                itemView.chat_container.background = resources.getDrawable(R.drawable.chat_bg_left)
                itemView.chat_view_global_container.gravity = Gravity.LEFT
            }
            itemView.setOnClickListener { listener(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatModelViewHolder {
        return PrivateMessagesAdapter.ChatModelViewHolder(
            inflate(
                parent.context,
                R.layout.private_messages_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
      return messagesList.size
    }

    override fun onBindViewHolder(holder: ChatModelViewHolder, position: Int) {
        holder.bind(messagesList[position], listener)
    }
}