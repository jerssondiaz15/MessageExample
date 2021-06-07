package com.example.messageexample.ui.view.messagedetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.messageexample.R
import com.example.messageexample.databinding.ActivityMainBinding
import com.example.messageexample.databinding.ActivityMessageDetailBinding

class MessageDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMessageDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {
            tvTittle.text = intent.getStringExtra("tittle")
            tvDescription.text = intent.getStringExtra("body")
        }
    }
}