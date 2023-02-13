package com.example.to_doapp.ui.theme.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_doapp.Utils.RequestState
import com.example.to_doapp.Utils.SearchAppBarState
import com.example.to_doapp.data.dao.models.ToDoTaskModel
import com.example.to_doapp.data.dao.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTaskModel>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<ToDoTaskModel>>> = _allTasks


    fun geAllTask() {
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllTasks.collect { savedTasks ->
                    _allTasks.value = RequestState.Success(savedTasks)
                }
            }
        } catch (
            e: Exception
        ) {
            _allTasks.value = RequestState.Error(e)
        }

    }

    private val _selectedTask: MutableStateFlow<ToDoTaskModel?> = MutableStateFlow(null)
    val selectedTask: StateFlow<ToDoTaskModel?> = _selectedTask
    fun getSelectedTask(taskId: Int?) {
        viewModelScope.launch {
            taskId?.let { selectedTaskId->
                repository.getSelectedTask(selectedTaskId).collect { selectedTask ->
                    _selectedTask.value= selectedTask
                }
            }

        }
    }

}