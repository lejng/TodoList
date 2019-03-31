package com.example.todolist.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.todolist.R
import com.example.todolist.utils.Constants
import com.example.todolist.model.Note
import com.example.todolist.utils.Navigator

class NoteInfoActivity : AppCompatActivity() {
    private lateinit var titleText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_info)
        initElements()
        var note = intent.getSerializableExtra(Constants.NOTE_KEY_FOR_NOTE_INFO_ACTIVITY) as Note
        fillFields(note)
    }

    private fun initElements(){
        titleText = findViewById(R.id.titleTextView)
        descriptionText = findViewById(R.id.descriptionTextView)
        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener{Navigator.getInstance()?.startNotesListActivity(this)}
    }

    private fun fillFields(note: Note){
        titleText.text = note.Title
        descriptionText.text = note.Description
    }
}