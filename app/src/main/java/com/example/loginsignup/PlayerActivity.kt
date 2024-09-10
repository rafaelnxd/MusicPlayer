package com.example.loginsignup

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PlayerActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var seekBar: SeekBar
    private lateinit var songTitle: TextView

    private var isPlaying = false
    private val handler = Handler(Looper.getMainLooper())  // To update SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        playButton = findViewById(R.id.btn_play)
        pauseButton = findViewById(R.id.btn_pause)
        seekBar = findViewById(R.id.seek_bar)
        songTitle = findViewById(R.id.song_title)

        val title = intent.getStringExtra("SONG_TITLE")
        val songResId = intent.getIntExtra("SONG_RESOURCE", R.raw.song1)  // Retrieve resource ID

        songTitle.text = title

        mediaPlayer = MediaPlayer.create(this, songResId)

        seekBar.max = mediaPlayer.duration


        playButton.setOnClickListener {
            if (!isPlaying) {
                mediaPlayer.start()
                isPlaying = true
                updateSeekBar()
            }
        }

        // Pause button listener
        pauseButton.setOnClickListener {
            if (isPlaying) {
                mediaPlayer.pause()
                isPlaying = false
            }
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Optionally, resume updates to SeekBar when user stops dragging
            }
        })


        mediaPlayer.setOnCompletionListener {
            isPlaying = false
            mediaPlayer.seekTo(0)
            seekBar.progress = 0
        }
    }

    private fun updateSeekBar() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (mediaPlayer != null && isPlaying) {
                    seekBar.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)  // Update every second
                }
            }
        }, 0)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
        handler.removeCallbacksAndMessages(null)  // Remove pending updates to the SeekBar
    }
}
