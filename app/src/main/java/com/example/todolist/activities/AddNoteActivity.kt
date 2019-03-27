package com.example.todolist.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import com.example.todolist.R
import com.example.todolist.database.AppDatabase
import com.example.todolist.models.Note

class AddNoteActivity : AppCompatActivity() {
    private lateinit var titleInput: EditText
    private lateinit var descriptionInput: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        initElements()
    }

    private fun initElements(){
        titleInput = findViewById(R.id.addTextTitle)
        descriptionInput = findViewById(R.id.addTextDescription)
        addButton = findViewById(R.id.addNewNoteButton)
        setClickListenerForAddButton()
    }

    private fun setClickListenerForAddButton(){
        addButton.setOnClickListener {
            AppDatabase.getInstance(applicationContext)?.getNoteDao()?.insertNotes(getNoteFromActivity())
            startActivity(Intent(this, NotesListActivity::class.java))
        }
    }

    private fun getNoteFromActivity(): Note{
        return Note(
            Id = null,
            Title = titleInput.text.toString(),
            Description = descriptionInput.text.toString()//,
            //DateOfCreated = Date(),
            //DateOfLastEditing = Date()
        )
    }
}