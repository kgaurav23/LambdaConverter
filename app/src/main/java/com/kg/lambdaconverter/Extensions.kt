package com.kg.lambdaconverter

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String, toastDuration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, toastDuration).show()
}