package com.example.to_doapp.data.dao.dao.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.to_doapp.data.dao.dao.ToDoDao
import com.example.to_doapp.data.dao.models.ToDoTaskModel

@Database(entities = [ToDoTaskModel::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}