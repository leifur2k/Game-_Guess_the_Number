package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var random: Int = 0
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        random = (0..100).random()

        binding.bt1.setOnClickListener {

            var num = binding.et1.text.toString()

            if (num.toInt() < 0 || num.toInt() > 100)
                binding.tv3.text = "Ваше число выходит за рамки!"
            else if (num.toInt() < random) {
                binding.tv3.text = "Ваше число МЕНЬШЕ загаданного..."
                count++
                binding.tv4.text = "Попытка: $count"
            }
            else if (num.toInt() > random) {
                binding.tv3.text = "Ваше число БОЛЬШЕ загаданного..."
                count++
                binding.tv4.text = "Попытка: $count"
            }
            else
                binding.tv3.text = "ВЫ УГАДАЛИ ЧИСЛО $random И ВЫЙГРАЛИ!!!"
        }
    }



}