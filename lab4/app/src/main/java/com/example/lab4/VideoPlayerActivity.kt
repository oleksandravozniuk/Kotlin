package com.example.lab4

import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        configureVideoView()
    }

    private var mediaController: MediaController? = null


    private fun configureVideoView() {

        videoView1.setVideoPath(
            "http://www.ebookfrenzy.com/android_book/movie.mp4")


        mediaController = MediaController(this)
        mediaController?.setAnchorView(videoView1)
        videoView1.setMediaController(mediaController)
        videoView1.setOnPreparedListener { mp ->
            mp.isLooping = true
        }
        videoView1.start()
    }
}