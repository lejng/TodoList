package com.example.todolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true) val Id: Int?,
    @ColumnInfo(name = "title") val Title: String,
    @ColumnInfo(name = "description") val Description: String,
    @ColumnInfo(name = "createdTimestamp") val CreatedTimestamp: Long,
    @ColumnInfo(name = "lastModifyTimestamp") val LastModifyTimestamp: Long
): Serializable