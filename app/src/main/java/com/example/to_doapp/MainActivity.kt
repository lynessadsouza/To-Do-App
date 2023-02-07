package com.example.to_doapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.to_doapp.data.dao.navigation.SetUpNavigation
import com.example.to_doapp.ui.theme.ToDoAppTheme
import com.example.to_doapp.ui.theme.ViewModel.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    private val toDoViewModel: ToDoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                navHostController = rememberNavController()
                SetUpNavigation(
                    navHostController = navHostController,
                    toDoViewModel = toDoViewModel
                )
            }
        }
    }
}
