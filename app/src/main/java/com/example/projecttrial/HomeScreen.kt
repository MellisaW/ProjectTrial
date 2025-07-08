package com.example.projecttrial

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.navigation.compose.rememberNavController

class HomeScreen : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the root layout with a background image
        val rootLayout = FrameLayout(this).apply {
            layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            //background = getDrawable(R.drawable.background)
        }

        // Create a vertical layout for content
        val contentLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            setPadding(40, 80, 40, 40)
            layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
        }

        // Title
        val titleText = TextView(this).apply {
            text = getString(R.string.app_title)
            textSize = 40f
            setTypeface(null, Typeface.BOLD)
            setTextColor("#4A148C".toColorInt()) // Dark purple
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 80)
        }

        // Spacer to push message to middle
        val topSpacer = Space(this).apply {
            layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, 0, 1f)
        }

        // Welcome message
        val welcomeText = TextView(this).apply {
            text = getString(R.string.welcome_message)
            textSize = 28f
            setTypeface(null, Typeface.BOLD)
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(30, 30, 30, 30)
            setBackgroundColor("#66000000".toColorInt())
            setShadowLayer(4f, 2f, 2f, Color.BLACK)
        }


        // Spacer to push button lower
        val bottomSpacer = Space(this).apply {
            layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, 0, 1.5f)
        }

        // Button
        val exploreButton = Button(this).apply {
            text = getString(R.string.explore_button)
            setTextColor(Color.WHITE)
            textSize = 18f
            setPadding(50, 20, 50, 20)
            background = getRoundedButtonDrawable("#3F51B5".toColorInt())
            layoutParams = LinearLayout.LayoutParams(
                MATCH_PARENT,
                WRAP_CONTENT
            ).apply {
                setMargins(0, 20, 0, 0)
            }
        }

        // Add views in order
        contentLayout.addView(titleText)
        contentLayout.addView(topSpacer)
        contentLayout.addView(welcomeText)
        contentLayout.addView(bottomSpacer)
        contentLayout.addView(exploreButton)

        rootLayout.addView(contentLayout)
        setContentView(rootLayout)

        // Button click
        exploreButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Helper to create a rounded background for the button
    private fun getRoundedButtonDrawable(color: Int): android.graphics.drawable.Drawable {
        val radius = 50f
        val shape = android.graphics.drawable.GradientDrawable().apply {
            shape = android.graphics.drawable.GradientDrawable.RECTANGLE
            cornerRadius = radius
            setColor(color)
        }
        return shape
    }
}