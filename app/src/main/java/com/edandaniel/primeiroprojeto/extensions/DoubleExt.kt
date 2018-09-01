package com.edandaniel.primeiroprojeto.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f",this)