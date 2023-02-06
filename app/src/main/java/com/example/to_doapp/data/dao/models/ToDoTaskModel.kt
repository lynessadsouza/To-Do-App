package com.example.to_doapp.data.dao.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.to_doapp.Utils.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTaskModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
