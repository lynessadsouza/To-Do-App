package com.example.to_doapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LowPriorityColor = Color(0xFF96E499)
val HighPriorityColor = Color(0xFFF84972)
val MediumPriorityColor = Color(0xFFFF6433)
val NonePriorityColor = Color(0xFFEDFFFD)

val Colors.taskItemBackgroundColor :Color
@Composable
get()=if(isLight)  Color.White else  Color.DarkGray

val Colors.taskItemTextColor :Color
    @Composable
    get()=if(isLight)  Color.DarkGray else  Color.LightGray