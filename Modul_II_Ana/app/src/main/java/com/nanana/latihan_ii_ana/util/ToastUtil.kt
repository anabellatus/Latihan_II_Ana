package com.nanana.latihan_ii_ana.util

import android.content.Context
import android.widget.Toast

fun tampilToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT ).show()
}
