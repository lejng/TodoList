package com.example.todolist.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true) val Id: Int?,
    @ColumnInfo(name = "title") val Title: String,
    @ColumnInfo(name = "description") val Description: String,
    @ColumnInfo(name = "createdTimestamp") val CreatedTimestamp: Long,
    @ColumnInfo(name = "lastModifyTimestamp") val LastModifyTimestamp: Long
): Serializable