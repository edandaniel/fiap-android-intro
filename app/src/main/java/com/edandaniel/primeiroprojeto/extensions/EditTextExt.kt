package com.edandaniel.primeiroprojeto.extensions

import android.widget.EditText

fun EditText.myClear() = this.setText("")

fun EditText.value() = this.text.toString()