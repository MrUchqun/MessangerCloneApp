package com.example.messangercloneapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messangercloneapp.R
import com.example.messangercloneapp.model.Room
import com.google.android.material.imageview.ShapeableImageView

class RoomAdapter(var context: Context, var items: ArrayList<Room>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_room_view, parent, false)
        return RoomViewHolder(view)
    }

    class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile: ShapeableImageView = view.findViewById(R.id.iv_profile_room)
        val tvFullName: TextView = view.findViewById(R.id.tv_fullName_room)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val room = items[position]
        if (holder is RoomViewHolder){
            holder.ivProfile.setImageResource(room.profile)
            holder.tvFullName.text = room.fullName
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}