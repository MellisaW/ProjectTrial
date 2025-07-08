package com.example.projecttrial

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.sp
import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent



@Composable
fun CourseExpandableCard(course: String, onRemove: (() -> Unit)? = null) {
    // state that remembers card is expanded
    var expanded by remember { mutableStateOf(false) }
    val details = Info.getDetails(course)
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            /* drop‑down */
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(course, style = MaterialTheme.typography.titleMedium, fontSize = 23.sp)

                Row {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                            else Icons.Default.KeyboardArrowDown,
                            contentDescription = if (expanded) "Collapse" else "Expand"
                        )
                    }
                    if (onRemove != null) {
                        IconButton(onClick = onRemove) {
                            Icon(Icons.Default.Delete, contentDescription = "Remove")
                        }
                    }
                }
            }
            }

            /* collapsible info */
            AnimatedVisibility(visible = expanded) {
                Column {
                    Text(details.paragraph1, style = MaterialTheme.typography.bodyMedium, fontSize = 22.sp)
                    Spacer(Modifier.height(4.dp))
                    Text(details.paragraph2, style = MaterialTheme.typography.bodyMedium, fontSize = 22.sp)
                    Spacer(Modifier.height(4.dp))
                    Text(details.paragraph3, style = MaterialTheme.typography.bodyMedium, fontSize = 22.sp)

                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "Read more online",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.primary,
                            textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier.clickable {
                            uriHandler.openUri(details.url)
                        }
                    )
                }
            }
        }
}

