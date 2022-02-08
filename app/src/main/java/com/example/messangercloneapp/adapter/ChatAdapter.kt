package com.example.messangercloneapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messangercloneapp.R
import com.example.messangercloneapp.model.Chat
import com.example.messangercloneapp.model.Message
import com.example.messangercloneapp.model.Room
import com.google.android.material.imageview.ShapeableImageView

class ChatAdapter(var context: Context, var items: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1

    override fun getItemViewType(position: Int): Int {
        val feed = items[position]
        if (feed.rooms.size > 0) return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
            return RoomViewHolder(context, view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return MessageViewHolder(view)
    }

    private fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView) {
        recyclerView.adapter = RoomAdapter(context, rooms)
    }

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        val tvFullName: TextView = view.findViewById(R.id.tv_fullName)
        var isOnline: LinearLayout = view.findViewById(R.id.is_online)
    }

    class RoomViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView = view.findViewById(R.id.room_recyclerView)

        init {
            recyclerView = view.findViewById(R.id.room_recyclerView)
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if (holder is RoomViewHolder) {
            refreshAdapter(chat.rooms, holder.recyclerView)
        }

        if (holder is MessageViewHolder) {
            holder.ivProfile.setImageResource(chat.message!!.profile)
            holder.tvFullName.text = chat.message!!.fullName

            val isOnline = holder.isOnline
            if (chat.message!!.isOnline) {
                isOnline.visibility = View.VISIBLE
            } else {
                isOnline.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}