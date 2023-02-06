package com.example.to_doapp.data.dao.repository

import com.example.to_doapp.data.dao.dao.ToDoDao
import com.example.to_doapp.data.dao.models.ToDoTaskModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {
    val getAllTasks: Flow<List<ToDoTaskModel>> = toDoDao.getAllTask()

    val sortByLowPriority: Flow<List<ToDoTaskModel>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<ToDoTaskModel>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<ToDoTaskModel> {
        return toDoDao.getSelectedTask(taskId)
    }

    suspend fun addTask(toDoTaskModel: ToDoTaskModel) {
        return toDoDao.addTask(toDoTaskModel = toDoTaskModel)
    }

    suspend fun updateTask(toDoTaskModel: ToDoTaskModel) {
        return toDoDao.updateTask(toDoTaskModel = toDoTaskModel)
    }

    suspend fun deleteTask(toDoTaskModel: ToDoTaskModel) {
        return toDoDao.deleteTask(toDoTaskModel = toDoTaskModel)
    }

    suspend fun deleteAllTask() {
        return toDoDao.deleteAllTask()
    }

    fun searchDatabase(search: String): Flow<List<ToDoTaskModel>> {
        return toDoDao.searchTask(searchQuery = search)
    }

}