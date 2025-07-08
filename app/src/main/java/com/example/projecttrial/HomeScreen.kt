package com.example.projecttrial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController // Import NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Content layout
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp, vertical = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = stringResource(id = R.string.app_title),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C), // Dark purple
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 80.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = R.string.welcome_message),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(30.dp)
                    .background(
                        color = Color(0x66000000),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .shadow(
                        elevation = 4.dp,
                        ambientColor = Color.Black,
                        spotColor = Color.Black
                    )
            )

            //Bottom Spacer with weight
            Spacer(modifier = Modifier.weight(1.5f))

            // Button
            Button(
                onClick = { navController.navigate("category") }, // Navigate to CategoryScreen on click
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5)),
                shape = RoundedCornerShape(50.dp), // Rounded button
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 0.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.explore_button),
                    color = Color.White,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 10.dp)
                )
            }
        }
    }
}