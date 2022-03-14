package com.example.openweatherapiexercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.openweatherapiexercise.search.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)

        supportFragmentManager.beginTransaction().add(
            R.id.fragment_container,
            SearchFragment()
        ).commit()
    }
}
