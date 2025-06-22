package com.example.projecttrial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseExplorerApp()
        }
    }
}

@Composable
fun CourseExplorerApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("general") { GeneralCoursesScreen(navController) }
        composable("gems") { HiddenGemsScreen(navController) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Course Explorer") }
            )
        }
    ) { paddingValues ->
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
                    fontSize = 20.sp,
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
                    fontSize = 20.sp,
                    maxLines = 1
                    )
            }
        }
    }
}

@Composable
fun CourseCategory(title: String, courses: List<String>) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
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
                style = MaterialTheme.typography.bodyLarge
            )
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add $course"
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralCoursesScreen(navController: NavHostController) {
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
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            CourseCategory(
                title = "STEM",
                courses = listOf("Physics", "Chemistry", "Biology")
            )
            Spacer(modifier = Modifier.height(16.dp))
            CourseCategory(
                title = "IT",
                courses = listOf("Programming", "Networks", "Cybersecurity")
            )
            Spacer(modifier = Modifier.height(16.dp))
            CourseCategory(
                title = "Humanities",
                courses = listOf("History", "Philosophy", "Languages")
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HiddenGemsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hidden Gems") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            listOf(
                "Astrobiology" to "Ever thought of mixing space with life science?",
                "Ethnomusicology" to "Study how culture influences music around the world.",
                "Science Journalism" to "Turn lab discoveries into engaging stories.",
                "Adventure Tourism" to "Blend travel with sustainable tourism design.",
                "Game Narrative Design" to "Create the story behind gameplay.",
                "Digital Anthropology" to "Explore humans in online spaces."
            ).forEach { (title, note) ->
                HiddenGemCourse(title, note)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun HiddenGemCourse(title: String, note: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add $title"
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = note,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}




