package com.example.to_doapp.data.dao.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_doapp.Utils.Constants.LIST_SCREEN
import com.example.to_doapp.data.dao.navigation.destination.listComposable
import com.example.to_doapp.data.dao.navigation.destination.taskComposable
import com.example.to_doapp.ui.theme.ViewModel.ToDoViewModel

@Composable
fun SetUpNavigation(
    navHostController: NavHostController,
    toDoViewModel: ToDoViewModel
) {
    val screens = remember(navHostController) {
        Screens(navController = navHostController)
    }
    NavHost(navController = navHostController, startDestination = LIST_SCREEN) {
        listComposable(navigateToTaskScreen = screens.task, toDoViewModel = toDoViewModel)
        taskComposable(navigateToListScreen = screens.list, toDoViewModel = toDoViewModel)

    }

}
