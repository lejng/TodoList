package com.example.todolist.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.example.todolist.R
import com.example.todolist.database.AppDatabase
import com.example.todolist.adapter.ListNotesAdapter

class NotesListActivity : AppCompatActivity() {
    private lateinit var listNotesRecycle: RecyclerView
    private lateinit var addNewNoteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)
        initElements()
    }

    private fun initElements(){
        listNotesRecycle = findViewById(R.id.listNotes)
        addNewNoteButton = findViewById(R.id.addNoteButton)
        setListNotesRecycleAdapter()
        addNewNoteButton.setOnClickListener {startActivity(Intent(this, AddNoteActivity::class.java))}
    }

    private fun setListNotesRecycleAdapter(){
        val allNotes = AppDatabase.getInstance(applicationContext)?.getNoteDao()?.getAllNotes()!!
        listNotesRecycle.adapter = ListNotesAdapter(this, allNotes)
    }
}
