package com.example.to_doapp.ui.theme.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.to_doapp.R
import com.example.to_doapp.Utils.SearchAppBarState
import com.example.to_doapp.ui.theme.ViewModel.ToDoViewModel
import com.example.to_doapp.ui.theme.screens.list.compoments.ListAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskInt: Int) -> Unit,
    toDoViewModel: ToDoViewModel
) {
    LaunchedEffect(key1 = true ){
        toDoViewModel.geAllTask()
    }


    val allTask by  toDoViewModel.allTasks.collectAsState()
    val searchAppBarState: SearchAppBarState by toDoViewModel.searchAppBarState
    val searchTextState: String by toDoViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(toDoViewModel, searchAppBarState, searchTextState)
        },
        content = { ListContent(allTask, navigateToTaskScreen) },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )


}

@Composable
fun ListFab(onFabClicked: (Int) -> Unit) {
    FloatingActionButton(onClick = {
        onFabClicked(-1)
    }) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_task),
            tint = Color.White
        )

    }
}

