package com.example.to_doapp.data.dao.dao

import androidx.room.*
import com.example.to_doapp.data.dao.models.ToDoTaskModel
import kotlinx.coroutines.flow.Flow


//Define sql queries
@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC ")
    fun getAllTask(): Flow<List<ToDoTaskModel>>

    @Query("SELECT * FROM todo_table WHERE id= :taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTaskModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTaskModel: ToDoTaskModel)

    @Delete
    suspend fun deleteTask(toDoTaskModel: ToDoTaskModel)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateTask(toDoTaskModel: ToDoTaskModel)

    @Query("DELETE  FROM todo_table")
    suspend fun deleteAllTask()

    @Query("SELECT *  FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchTask(searchQuery: String): Flow<List<ToDoTaskModel>>


    @Query("SELECT *  FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<ToDoTaskModel>>

    @Query("SELECT *  FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoTaskModel>>


}