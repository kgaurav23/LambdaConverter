package com.kg.lambdaconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvFinalValue.visibility = View.GONE

        val converterMilesToKms: (Double) -> Double = { it * 1.6}
        val converterCelciusToFarenheit: (Double) -> Double = { it * 1.8 + 32 }

        btnCelToFar.setOnClickListener {
            val inputValue = etInput.text.toString()
            if(inputValue.isBlank()) {
                showToast("Please enter some value")
                return@setOnClickListener
            }

            val result = convert(etInput.text.toString().toDouble(), converterCelciusToFarenheit)
            val message = "$inputValue celcius is equal to $result fahrenheit"
            showToast(message)

            tvFinalValue.visibility = View.VISIBLE
            tvFinalValue.text = "Result: $message"
        }

        btnMilesToKm.setOnClickListener {
            val inputValue = etInput.text.toString()
            if(inputValue.isBlank()) {
                showToast("Please enter some value")
                return@setOnClickListener
            }

            val result = convert(etInput.text.toString().toDouble(), converterMilesToKms)
            val message = "$inputValue miles is equal to $result kms"
            showToast(message)

            tvFinalValue.visibility = View.VISIBLE
            tvFinalValue.text = "Result: $message"
        }
    }

    private fun convert(x: Double, converter: (Double) -> Double): Double {
        return converter(x)
    }
}
