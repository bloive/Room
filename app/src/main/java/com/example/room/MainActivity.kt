package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.activity.viewModels
import com.example.room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        observe()

        binding.btnRead.setOnClickListener {
            viewModel.read()
        }

        binding.btnWrite.setOnClickListener {
            viewModel.write(
                binding.etFirstName.text.toString().trim(),
                binding.tvLastName.text.toString().trim(),
                binding.etAge.text.toString().trim().toInt(),
                binding.etAddress.text.toString().trim(),
                binding.etHeight.text.toString().trim(),
                binding.etProfile.text.toString().trim()
            )
        }

    }

    private fun observe() {
        viewModel.users.observe(this, {
            d("users", "${it.size}")
        })
    }
}