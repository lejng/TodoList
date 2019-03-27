package com.example.todolist.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true) val Id: Int?,
    @ColumnInfo(name = "title") val Title: String,
    @ColumnInfo(name = "description") val Description: String//,
   // @ColumnInfo(name = "date_of_created") val DateOfCreated: Date,
   // @ColumnInfo(name = "date_of_last_editing") val DateOfLastEditing: Date
): Serializable