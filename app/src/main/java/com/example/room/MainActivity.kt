package com.example.room

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log.d
import android.view.Window
import android.view.WindowManager
import android.view.WindowMetrics
import android.widget.Button
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

        binding.btnDialog.setOnClickListener {
            showMyDialog()
        }

    }

    private fun observe() {
        viewModel.users.observe(this, {
            d("users", "${it.size}")
        })
    }

    private fun showMyDialog() {
        val dialog = Dialog(this)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_view)

        val displayMetrics = DisplayMetrics()

        val params = dialog.window!!.attributes
        params.width = WindowManager.LayoutParams.MATCH_PARENT
        params.height = WindowManager.LayoutParams.WRAP_CONTENT

        dialog.findViewById<Button>(R.id.dialog_done).setOnClickListener {
            dialog.hide()
        }

        dialog.show()
    }
}