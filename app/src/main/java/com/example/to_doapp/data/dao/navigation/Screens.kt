package com.example.to_doapp.data.dao.navigation

import androidx.navigation.NavHostController
import com.example.to_doapp.Utils.Action
import com.example.to_doapp.Utils.Constants.LIST_SCREEN

class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}