package com.example.projecttrial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import kotlinx.coroutines.launch
import com.example.projecttrial.SelectedCourses
import com.example.projecttrial.GeneralCoursesScreen
import com.example.projecttrial.HiddenGemsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            CourseDataStore.getCourses(applicationContext).collect { saved ->
                SelectedCourses.restoreFromSet(saved)
            }
        }

        setContent {
            CourseExplorerApp()
        }
    }

    override fun onStop() {
        super.onStop()
        lifecycleScope.launch {
            CourseDataStore.saveCourses(applicationContext, SelectedCourses.asSet())
        }
    }

}

@Composable
fun CourseExplorerApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("category") { CategoryScreen(navController) }
        composable("general") { GeneralCoursesScreen(navController) }
        composable("gems") { HiddenGemsScreen(navController) }
        composable("selected") { SelectedCoursesScreen(navController) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(navController: NavHostController) {
    Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                            Text(
                                text = "Category Picker",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold
                            )
                    }
                },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFFC8E6C9)
                    )
                )
            }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.pick),
                contentDescription = "Background Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

        }
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("general") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "General Courses",
                    fontSize = 24.sp,
                    maxLines = 1
                )
            }

            Button(
                onClick = { navController.navigate("gems") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Hidden Gems",
                    fontSize = 24.sp,
                    maxLines = 1
                    )
            }

            Button(
                onClick = { navController.navigate("selected") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Selected Courses",
                    fontSize = 24.sp
                    )
            }
        }
    }
}

@Composable
fun CourseCategory(title: String, courses: List<String>, snackbarHostState: SnackbarHostState) {
    val coroutineScope = rememberCoroutineScope()

    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 8.dp)
    )

    courses.forEach { course ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = course,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 22.sp
            )
            IconButton(onClick = {
                           SelectedCourses.addCourse(course)
                           coroutineScope.launch {
                               snackbarHostState.showSnackbar("$course added")
                           }
                      }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add $course"
                )
            }
        }
    }
}