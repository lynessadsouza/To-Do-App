package com.example.to_doapp.ui.theme.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.to_doapp.data.dao.models.ToDoTaskModel
import com.example.to_doapp.ui.theme.taskItemBackgroundColor
import com.example.to_doapp.ui.theme.taskItemTextColor

@Composable
fun ListContent(
    tasks: List<ToDoTaskModel>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    LazyColumn() {

        items(items = tasks, key = { tasks ->
            tasks.id

        }) { task ->
            TaskItem(task, navigateToTaskScreen)
        }


    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskItem(
    toDoTaskModel: ToDoTaskModel,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = 2.dp,
        onClick = {
            navigateToTaskScreen(toDoTaskModel.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = toDoTaskModel.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(modifier = Modifier
                        .width(16.dp)
                        .height(16.dp), onDraw = {
                        drawCircle(
                            color = toDoTaskModel.priority.color
                        )
                    })
                }
            }
            Text(
                text = toDoTaskModel.description,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
