package com.example.to_doapp.data.dao.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_doapp.Utils.Constants.LIST_ARGUMENT_KEY
import com.example.to_doapp.Utils.Constants.LIST_SCREEN
import com.example.to_doapp.ui.theme.ViewModel.ToDoViewModel
import com.example.to_doapp.ui.theme.screens.list.ListScreen

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskInt: Int) -> Unit,
    toDoViewModel: ToDoViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    )
    {
        ListScreen(navigateToTaskScreen = navigateToTaskScreen, toDoViewModel = toDoViewModel)
    }
}