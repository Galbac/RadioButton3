package com.example.radiobutton


import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.radiobutton.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
private  lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroupGender.clearCheck();

        radioGroupGender.setOnCheckedChangeListener{ group, checkedId ->
            when (checkedId) {
                -1 -> showToast("Не выбрано")
                R.id.rbNamazForMen -> showToast("Мужчина")
                R.id.rbNamazForWoman -> showToast("Женщина")
            }
        }


    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}