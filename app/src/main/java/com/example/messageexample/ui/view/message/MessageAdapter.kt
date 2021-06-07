package com.example.messageexample.ui.view.message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.messageexample.R
import com.example.messageexample.data.model.MessageModel
import com.example.messageexample.databinding.CardMessageBinding

class MessageAdapter (
    val context: Context,
    val messageList : List<MessageModel>,
    var itemClick: ElementClick,
    ) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    var listener : ElementClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_message, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = messageList[position]
        holder.bindMessageModel(item, position)
    }

    override fun getItemCount(): Int {
        return messageList.count()
    }

    fun delete(position: Int){
        messageList.drop(position)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val binding = CardMessageBinding.bind(itemView)

        fun bindMessageModel(item : MessageModel, position : Int) = with(binding){
            itemView.setOnClickListener {
                itemClick.onElementClick(item)
            }
            if (position >= 20){
                if (!item.isRead){
                    ivUnread.visibility = View.GONE
                }
            } else if (position <= 20){
                if (item.isRead){
                    ivUnread.visibility = View.GONE
                }
            }
            tvTittle.text = item.title
            tvDescription.text = item.body
        }
    }

    interface ElementClick {
        fun onElementClick(element: MessageModel)
    }
}