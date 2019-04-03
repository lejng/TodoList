package com.example.todolist.utils

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.activity.AddNoteActivity
import com.example.todolist.activity.NoteInfoActivity
import com.example.todolist.activity.NotesListActivity
import com.example.todolist.model.Note
import kotlin.reflect.KClass

class Navigator {
    companion object {
        private var Instance : Navigator ? = null

        fun getInstance(): Navigator?{
            if(Instance == null){
                synchronized(Navigator::class) {
                    Instance = Navigator()
                }
            }
            return Instance
        }
    }

    fun startNoteInfoActivity(context: Context, note: Note){
        var intent = Intent(context, NoteInfoActivity::class.java)
        intent.putExtra(Constants.NOTE_KEY_FOR_NOTE_INFO_ACTIVITY, note)
        context.startActivity(intent)
    }

    fun startNotesListActivity(context: Context){
        startSimpleActivity(context, NotesListActivity::class)
    }

    fun startAddNoteActivity(context: Context){
        startSimpleActivity(context, AddNoteActivity::class)
    }

    private fun <T : AppCompatActivity> startSimpleActivity(context: Context, cls: KClass<T>){
        var intent = Intent(context, cls.java)
        context.startActivity(intent)
    }
}