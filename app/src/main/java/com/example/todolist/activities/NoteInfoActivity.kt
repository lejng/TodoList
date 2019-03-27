package com.example.todolist.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.todolist.R
import com.example.todolist.enums.ExtraNames
import com.example.todolist.models.Note

class NoteInfoActivity : AppCompatActivity() {
    private lateinit var titleText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_info)
        initElements()
        var note = intent.getSerializableExtra(ExtraNames.NOTE.Name) as Note
        fillFields(note)
    }

    private fun initElements(){
        titleText = findViewById(R.id.titleTextView)
        descriptionText = findViewById(R.id.descriptionTextView)
        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener{startActivity(Intent(this, NotesListActivity::class.java))}
    }

    private fun fillFields(note: Note){
        titleText.text = note.Title
        descriptionText.text = note.Description
    }
}