package com.example.to_doapp.data.dao.navigation.destination

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_doapp.Utils.Action
import com.example.to_doapp.Utils.Constants.TASK_ARGUMENT_KEY
import com.example.to_doapp.Utils.Constants.TASK_SCREEN
import com.example.to_doapp.ui.theme.ViewModel.ToDoViewModel
import com.example.to_doapp.ui.theme.screens.tasks.TaskScreen

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
    toDoViewModel: ToDoViewModel
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments?.getInt(TASK_ARGUMENT_KEY)
        toDoViewModel.getSelectedTask(taskId)
        val selectedTask by toDoViewModel.selectedTask.collectAsState()
        TaskScreen(navigateToListScreen = navigateToListScreen, selectedTask= selectedTask)
    }
}