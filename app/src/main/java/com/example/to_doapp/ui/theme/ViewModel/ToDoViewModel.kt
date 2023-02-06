package com.example.to_doapp.ui.theme.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.data.dao.models.ToDoTaskModel
import com.example.to_doapp.data.dao.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    private val _allTasks = MutableStateFlow<List<ToDoTaskModel>>(emptyList())
    val allTasks: StateFlow<List<ToDoTaskModel>> = _allTasks


    fun geAllTask() {
        viewModelScope.launch {
            repository.getAllTasks.collect { savedTasks ->
                _allTasks.value = savedTasks
            }

        }
    }
}