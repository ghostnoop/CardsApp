package crd.ctin.cardstinapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cards_view.view.*
import java.io.Serializable

fun inflate(context: Context, viewId: Int, parent: ViewGroup? = null, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(viewId, parent, attachToRoot)
}

class CardAdapter(private val context: Context, private val humans: List<Girl>, private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<CardAdapter.HumanModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanModelViewHolder {
        return HumanModelViewHolder(inflate(parent.context, R.layout.cards_view, parent, false))
    }

    override fun onBindViewHolder(
        holder: HumanModelViewHolder,
        position: Int
    ) {
        holder.bind(humans[position], listener)
    }

    override fun getItemCount(): Int {
        return humans.size
    }


    class HumanModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun bind(human: Girl, listener: (Int) -> Unit) = with(itemView) {

            Glide.with(itemView).load(human.imageURL).centerInside().into(itemView.image)

        }
    }

}