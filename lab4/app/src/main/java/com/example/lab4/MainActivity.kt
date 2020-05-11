package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun youtube(view: View)
    {
        val intent = Intent(this, AndroidYoutubePlayerActivity::class.java)
        // start your next activity
        startActivity(intent)
    }

    fun video(view: View) {
        val intent = Intent(this, VideoPlayerActivity::class.java)
        // start your next activity
        startActivity(intent)
    }

    fun audio(view: View) {
        val intent = Intent(this, AudioPlayerActivity::class.java)
        // start your next activity
        startActivity(intent)
    }

}
