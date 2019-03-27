package com.example.todolist.adapter

import android.support.v7.widget.RecyclerView
import com.example.todolist.model.Note
import android.content.Context
import android.content.Intent
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.todolist.R
import com.example.todolist.activity.NoteInfoActivity
import com.example.todolist.utils.Constants

class ListNotesAdapter : RecyclerView.Adapter<ListNotesAdapter.NoteViewHolder> {

    private var notes: List<Note>
    private var inflater: LayoutInflater

    constructor(context: Context, notes: List<Note>) {
        this.notes = notes
        this.inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val view = inflater.inflate(R.layout.note_list_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        var note = notes[position]
        holder.fillFields(note)
        holder.titleView.setOnClickListener{
            var intent = Intent(inflater.context, NoteInfoActivity::class.java)
            intent.putExtra(Constants.NOTE_KEY_FOR_NOTE_INFO_ACTIVITY, note)
            inflater.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class NoteViewHolder : RecyclerView.ViewHolder {
        val titleView: TextView

        constructor(itemView: View): super(itemView){
            titleView = itemView.findViewById(R.id.titleNote)
        }

        fun fillFields(note: Note){
            titleView.text = note.Title
        }
    }
}