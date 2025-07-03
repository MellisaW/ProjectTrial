package com.example.projecttrial

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalUriHandler


@Composable
fun CourseExpandableCard(course: String) {
    // state that remembers if THIS card is expanded
    var expanded by remember { mutableStateOf(false) }
    val (p1, p2, p3) = CourseInfo.detailsFor(course)
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),      // smooth height change
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            /* ── row: title + drop‑down arrow ───────────────────────── */
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(course, style = MaterialTheme.typography.titleMedium)
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                        else Icons.Default.KeyboardArrowDown,
                        contentDescription = if (expanded) "Collapse" else "Expand"
                    )
                }
            }

            /* ── collasible info ────────────────────────────────────── */
            AnimatedVisibility(expanded) {
                Column {
                    Text(p1, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(4.dp))
                    Text(p2, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(4.dp))
                    Text(p3, style = MaterialTheme.typography.bodyMedium)

                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Read more online",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.primary,
                            textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier.clickable {
                            uriHandler.openUri("https://www.google.com/search?q=$course degree")
                        }
                    )
                }
            }
        }
    }
}

