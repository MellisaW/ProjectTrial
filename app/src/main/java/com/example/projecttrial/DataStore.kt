package com.example.projecttrial

import androidx.compose.runtime.mutableStateListOf

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
}


object CourseInfo {
    /** short, three–paragraph blurbs (≈ 4 sentences each) + reference url   */
    val blurb: Map<String, Triple<String, String, String>> = mapOf(
        "Astrobiology" to Triple(
            /* p1 */ "Astrobiology explores life’s possibilities beyond Earth— merging astronomy, biology, and geology.",
            /* p2 */ "You’ll gain lab skills in microbiology and field experience in planetary simulation facilities.  Degree paths exist at BSc, MSc and PhD level; a 4‑year track is common, but many universities now offer 2‑year diplomas for fast‑track researchers.",
            /* p3 */ "Graduates work at NASA, ESA and private space firms.  Alumni like Dr. Penelope Boston have shaped Mars‑cave exploration."),
        /* add more as you like… */
    )

    /** fallback text if we have no custom entry yet */
    fun generic(course: String): Triple<String, String, String> =
        Triple(
            "This course opens unique career paths by combining theory and hands‑on projects.",
            "Most programmes last 4 years (with diploma/shor‑track options available).  Core skills include critical thinking, communication, and specialised lab work.",
            "Check departmental pages for scholarship info and notable alumni."
        )

    /** quick helper */
    fun detailsFor(course: String): Triple<String, String, String> =
        blurb[course] ?: generic(course)
}
