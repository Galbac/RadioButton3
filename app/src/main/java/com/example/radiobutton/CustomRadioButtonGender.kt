package com.example.radiobutton

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRadioButton

class CustomRadioButtonGender : AppCompatRadioButton {
    private var view: View? = null
    private var textView: TextView? = null
    private var imageView: ImageView? = null


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }

    @SuppressLint("InflateParams")
    private fun init(context: Context) {
        view = LayoutInflater.from(context).inflate(R.layout.custom_radio_button_gender, null)
        textView = view?.findViewById(R.id.tvGender)
        imageView = view?.findViewById(R.id.imGender)


    }


    fun setTextAndImageWith(TextResId: Int, imageResId: Int) {
        textView!!.setText(TextResId)
        imageView!!.setImageResource(imageResId)
        redrawLayout()
    }




        private fun redrawLayout() {
        view!!.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)
        view!!.layout(0, 0, view!!.measuredWidth, view!!.measuredHeight)

        val bitmap = Bitmap.createBitmap(view!!.width, view!!.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
        view!!.draw(canvas)

        setCompoundDrawablesWithIntrinsicBounds(BitmapDrawable(resources, bitmap), null, null, null)
    }




}
