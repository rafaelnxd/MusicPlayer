package com.example.loginsignup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    private lateinit var logoutBtn: Button
    private lateinit var welcomeText: TextView
    private lateinit var groupInfoBtn: Button
    private lateinit var songListBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        logoutBtn = findViewById(R.id.logout_btn)
        welcomeText = findViewById(R.id.welcome_text)
        groupInfoBtn = findViewById(R.id.group_info_btn)
        songListBtn = findViewById(R.id.song_list_btn)

        val username = intent.getStringExtra("USERNAME")
        welcomeText.text = "Welcome, $username"


        logoutBtn.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        groupInfoBtn.setOnClickListener {

            val intent = Intent(this, GroupInfoActivity::class.java)
            startActivity(intent)
        }


        songListBtn.setOnClickListener {
            val intent = Intent(this, SongListActivity::class.java)
            startActivity(intent)
        }
    }
}
