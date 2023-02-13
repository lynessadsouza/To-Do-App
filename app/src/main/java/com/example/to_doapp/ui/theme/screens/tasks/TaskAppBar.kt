package com.example.to_doapp.ui.theme.screens.tasks

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.example.to_doapp.Utils.Action
import com.example.to_doapp.data.dao.models.ToDoTaskModel

@Composable
fun TaskAppBar(navigateToListScreen: (Action) -> Unit, selectedTask: ToDoTaskModel?) {
    if (selectedTask == null) {
        NewTaskAppBar(navigateToListScreen = navigateToListScreen)
    } else {
        ExistingTaskAppBar(selectedTask = selectedTask, navigateToListScreen = navigateToListScreen)
    }

}


@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = { Text(text = "Add Task") },
        backgroundColor = MaterialTheme.colors.primary,
        actions = {
            AddAction(onBackClicked = navigateToListScreen)
        }
    )
}

@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTaskModel,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = { Text(text = selectedTask.title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
        backgroundColor = MaterialTheme.colors.primary,
        actions = {
            DeleteAction(onDeleteClicked = navigateToListScreen)
            UpdateAction(onCloseClicked = navigateToListScreen)

        }
    )
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
) {
    IconButton(onClick = { onCloseClicked(Action.NO_ACTION) }) {
        Icon(imageVector = Icons.Filled.Close, contentDescription = "Close Button")
    }
}

@Composable
fun DeleteAction(
    onDeleteClicked: (Action) -> Unit
) {
    IconButton(onClick = { onDeleteClicked(Action.DELETE) }) {
        Icon(imageVector = Icons.Filled.Check, contentDescription = "Update Button")
    }
}

@Composable
fun UpdateAction(
    onCloseClicked: (Action) -> Unit
) {
    IconButton(onClick = { onCloseClicked(Action.DELETE) }) {
        Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Button")
    }
}


@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back Arrow Button")
    }
}

@Composable
fun AddAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = { onBackClicked(Action.ADD) }) {
        Icon(imageVector = Icons.Filled.Check, contentDescription = "Add Task")
    }
}