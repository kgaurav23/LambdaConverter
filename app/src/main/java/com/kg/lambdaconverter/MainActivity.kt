package com.kg.lambdaconverter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvFinalValue.visibility = View.GONE

        val converterMilesToKms: (Double) -> Double = { it * 1.6}
        val converterCelciusToFahrenheit: (Double) -> Double = { it * 1.8 + 32 }

        celciusToFahrenheitButtonClick(converterCelciusToFahrenheit)

        milesToKmButtonClick(converterMilesToKms)
    }

    private fun milesToKmButtonClick(converterMilesToKms: (Double) -> Double) {
        btnMilesToKm.setOnClickListener {
            val inputValue = etInput.text.toString()
            if (inputValue.isBlank()) {
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

    private fun celciusToFahrenheitButtonClick(converterCelciusToFahrenheit: (Double) -> Double) {
        btnCelToFar.setOnClickListener {
            val inputValue = etInput.text.toString()
            if (inputValue.isBlank()) {
                showToast("Please enter some value")
                return@setOnClickListener
            }

            val result = convert(etInput.text.toString().toDouble(), converterCelciusToFahrenheit)
            val message = "$inputValue celcius is equal to $result fahrenheit"
            showToast(message)

            tvFinalValue.visibility = View.VISIBLE
            tvFinalValue.text = "Result: $message"
        }
    }

    private fun convert(x: Double, converter: (Double) -> Double): Double {
        return converter(x)
    }
}
