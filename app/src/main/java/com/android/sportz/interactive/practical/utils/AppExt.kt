package com.android.sportz.interactive.practical.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.Alert(message: String){
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}
