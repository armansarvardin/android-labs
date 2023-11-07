package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab1.databinding.ActivityMainBinding
import com.example.lab1.fragments.MainFragment
import com.example.lab1.fragments.SelectedItemsListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, MainFragment())
            .commit()
    }
}