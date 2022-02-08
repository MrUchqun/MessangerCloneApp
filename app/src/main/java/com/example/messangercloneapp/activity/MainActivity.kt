package com.example.messangercloneapp.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.messangercloneapp.model.Message
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.messangercloneapp.R
import com.example.messangercloneapp.adapter.ChatAdapter
import com.example.messangercloneapp.model.Chat
import com.example.messangercloneapp.model.Room

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        refreshAdapter(getChats(getMessages(), getRooms()))
    }

    private fun getRooms(): ArrayList<Room> {
        val rooms: ArrayList<Room> = ArrayList()
        rooms.add(Room(R.drawable.ic_baseline_video_call_24,"Create    room"))
        for (i in 0..3){
            rooms.add(Room(R.drawable.img1,"Begzodbek Kurbanov"))
            rooms.add(Room(R.drawable.img2,"Sherzodbek Kurbanov"))
            rooms.add(Room(R.drawable.img3,"Xurshidbek Kurbanov"))
        }
        return rooms
    }

    private fun getMessages(): ArrayList<Chat> {
        val messages: ArrayList<Chat> = ArrayList()
        for (i in 0..10) {
            messages.add(Chat(Message(R.drawable.img1, "Begzodbek Kurbanov")))
            messages.add(Chat(Message(R.drawable.img2, "Sherzodbek Kurbanov")))
            messages.add(Chat(Message(R.drawable.img3, "Xurshidbek Kurbanov", true)))
        }
        return messages
    }

    private fun getChats(messages: ArrayList<Chat>, rooms: ArrayList<Room>): ArrayList<Chat> {
        val chats: ArrayList<Chat> = ArrayList()
        chats.add(Chat(rooms))
        chats.addAll(messages)
        return chats
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        recyclerView.adapter = ChatAdapter(context, chats)
    }
}