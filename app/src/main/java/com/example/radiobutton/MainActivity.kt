package com.example.radiobutton


import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.radiobutton.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val customRadioButtonGender = findViewById<CustomRadioButtonGender>(R.id.radiocustom)
        val customRadioButtonGender2 = findViewById<CustomRadioButtonGender>(R.id.radiocustom2)
        customRadioButtonGender.setTextAndImageWith(R.string.men, R.drawable.ic_selected_men)
        customRadioButtonGender2.setTextAndImageWith(R.string.woman, R.drawable.selected_woman)

        radioGroup.setOnCheckedChangeListener { _, chekedId ->
            Log.d("MyLog","$chekedId")
            val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrateExt(50)
            when (chekedId) {
                customRadioButtonGender.id -> showToast("Мужской")
                customRadioButtonGender2.id -> showToast("Женский")
            }
        }


    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun commonClickListenerForGenders(): View.OnClickListener {


        return View.OnClickListener { view ->
            val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrateExt(50)
            val customRadioButtonGender = findViewById<CustomRadioButtonGender>(R.id.radiocustom)
            val customRadioButtonGender2 = findViewById<CustomRadioButtonGender>(R.id.radiocustom2)
            customRadioButtonGender.setTextAndImageWith(R.string.men, R.drawable.ic_selected_men)
            customRadioButtonGender2.setTextAndImageWith(R.string.woman, R.drawable.selected_woman)
            when (view) {

                customRadioButtonGender -> Toast.makeText(
                    applicationContext,
                    "Мужской",
                    Toast.LENGTH_SHORT
                ).show()

                customRadioButtonGender2 -> Toast.makeText(
                    applicationContext,
                    "Женский",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
}