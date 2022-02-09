package com.example.messangercloneapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.messangercloneapp.R
import com.example.messangercloneapp.model.Room
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context, var items: ArrayList<Room>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }
}