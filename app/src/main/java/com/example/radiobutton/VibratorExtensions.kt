package com.example.radiobutton

import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

fun Vibrator.vibrateExt(timeInMillis: Long) {
    if (hasVibrator()) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.vibrate(
                VibrationEffect.createOneShot(
                    timeInMillis,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        } else {
            this.vibrate(timeInMillis)
        }
    }

}
