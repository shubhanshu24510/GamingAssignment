package com.shubhans.gamingassignment.ui.details

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.shubhans.gamingassignment.R
import com.shubhans.gamingassignment.R.id.progressBar
import androidx.core.graphics.drawable.toDrawable

class DetailActivity : ComponentActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView = findViewById<ImageView>(R.id.detailImage)
        val sizeTextView = findViewById<TextView>(R.id.sizeTextView)

        val imageUrl = intent.getStringExtra("image_url")
        val imageWidth = intent.getIntExtra("image_width", 0)
        val imageHeight = intent.getIntExtra("image_height", 0)

        val placeholderDrawable = Color.LTGRAY.toDrawable() // Light gray background
        Glide.with(this)
            .load(imageUrl)
            .placeholder(placeholderDrawable) // Use a color as placeholder
            .into(imageView)

        sizeTextView.text = "Width: ${imageWidth}px  Height: ${imageHeight}px"
    }
}


