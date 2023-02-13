package com.example.to_doapp.ui.theme.screens.tasks

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.to_doapp.Utils.Action
import com.example.to_doapp.data.dao.models.ToDoTaskModel

@Composable
fun TaskScreen( navigateToListScreen: (Action) -> Unit , selectedTask: ToDoTaskModel?) {
    Scaffold(
        topBar = {
                 TaskAppBar(navigateToListScreen = navigateToListScreen)
        },
        content = {}
    )
}
