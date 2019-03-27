package com.example.todolist.views

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.todolist.R
import com.example.todolist.models.Note

class NoteViewHolder : RecyclerView.ViewHolder {
    val titleView: TextView

    constructor(itemView: View): super(itemView){
        titleView = itemView.findViewById(R.id.titleNote)
    }

    fun fillFields(note: Note){
        titleView.text = note.Title
    }
}