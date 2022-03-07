package com.example.shanappguestnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shanappguestnumber.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Thread(Runnable { try {
                var number1 = binding.editNumber.text.toString().toInt()
                var randomInt = 0

                for ( i in number1 downTo 0){
                    var random = (Math.random() * number1 + 1).toInt()
                    binding.randomNumberView.text = random.toString()

                    if (number1 == 0){
                        binding.result.text = "Win!"
                    } else if (number1 == random){
                        binding.result.text = "Lose!"

                    } else{
                        number1 -=1
                        binding.timerView.text = number1.toString()
                        Thread.sleep(1000)
                    }




                    randomInt = random

                }
                
            }catch (e: Exception){binding.result.text = "Input number"}
            }).start()

        }
    }
}