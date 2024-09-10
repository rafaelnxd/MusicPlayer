package com.example.loginsignup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SongListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)


        val songs = listOf(
            Song("Lovers Rock", "TV Girl", R.raw.song1),
            Song("505", "Arctic Monkeys", R.raw.song2),
            Song("L’AMOUR DE MA VIE", "Billie Eilish", R.raw.song3)  // Add song3 to raw folder
        )


        recyclerView = findViewById(R.id.song_list)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = SongAdapter(songs) { song ->

            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("SONG_TITLE", song.name)
            intent.putExtra("SONG_RESOURCE", song.resourceId)  // Pass the correct resource ID
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}
