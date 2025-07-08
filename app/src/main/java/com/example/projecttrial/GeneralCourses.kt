package com.example.projecttrial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralCoursesScreen(navController: NavHostController) {
    val snackbarHostState = remember { SnackbarHostState() }
    val backgroundColor = Color(0xFFE8F0FE)

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("General Courses") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
                .background(backgroundColor)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            CourseCategory(
                title = "STEM",
                courses = listOf("Physics", "Chemistry", "Biology"),
                snackbarHostState = snackbarHostState
            )
            Spacer(modifier = Modifier.height(16.dp))

            CourseCategory(
                title = "IT",
                courses = listOf("Programming", "Networks", "Cybersecurity"),
                snackbarHostState = snackbarHostState
            )
            Spacer(modifier = Modifier.height(16.dp))

            CourseCategory(
                title = "HUMANITIES",
                courses = listOf("History", "Philosophy", "Languages"),
                snackbarHostState = snackbarHostState
            )
        }
    }
}