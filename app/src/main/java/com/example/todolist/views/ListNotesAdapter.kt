package com.example.todolist.views

import android.support.v7.widget.RecyclerView
import com.example.todolist.models.Note
import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.todolist.R
import com.example.todolist.enums.ExtraNames

class ListNotesAdapter : RecyclerView.Adapter<NoteViewHolder> {

    private var notes: List<Note>
    private var inflater: LayoutInflater
    private var intent: Intent

    constructor(context: Context, notes: List<Note>, intent: Intent) {
        this.notes = notes
        this.inflater = LayoutInflater.from(context)
        this.intent = intent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val view = inflater.inflate(R.layout.note_list_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var note = notes[position]
        holder.fillFields(note)
        holder.titleView.setOnClickListener{
            intent.putExtra(ExtraNames.NOTE.Name, note)
            inflater.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}