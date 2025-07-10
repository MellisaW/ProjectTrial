package com.example.projecttrial

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object SelectedCourses {
    val selectedList = mutableStateListOf<String>()

    fun addCourse(course: String) {
        if (!selectedList.contains(course)) {
            selectedList.add(course)
        }
    }

    fun removeCourse(course: String) {
        selectedList.remove(course)
    }

    fun restoreFromSet(set: Set<String>) {
        selectedList.clear()
        selectedList.addAll(set)
    }

    fun asSet(): Set<String> = selectedList.toSet()

}


private val Context.dataStore by preferencesDataStore("selected_courses")

object CourseDataStore {
    private val SELECTED_COURSES = stringSetPreferencesKey("selected_courses")

    suspend fun saveCourses(context: Context, courses: Set<String>) {
        context.dataStore.edit { prefs ->
            prefs[SELECTED_COURSES] = courses
        }
    }

    fun getCourses(context: Context): Flow<Set<String>> {
        return context.dataStore.data.map { prefs ->
            prefs[SELECTED_COURSES] ?: emptySet()
        }
    }
}

