package com.example.radiobutton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioButton = findViewById<CustomRadioButtonGender>(R.id.customRadioButton)
        radioButton.setTextAndImageWith(R.string.men,R.drawable.ic_selected_men)

        val radioButton2 = findViewById<CustomRadioButtonGender>(R.id.customRadioButton2)
        radioButton2.setTextAndImageWith(R.string.woman,R.drawable.selected_woman)


    }
}