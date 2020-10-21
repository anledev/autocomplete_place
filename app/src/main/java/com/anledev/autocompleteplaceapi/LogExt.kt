package com.anledev.autocompleteplaceapi

import android.util.Log

fun Any.e(any: Any? = "no message provided") {
    Log.e(this.javaClass.simpleName + "~", any.toString())
}

fun Any.i(any: Any? = "no message provided") {
    Log.i(this.javaClass.simpleName + "~", any.toString())
}

fun Any.d(any: Any? = "no message provided") {
    Log.d(this.javaClass.simpleName + "~", any.toString())
}

fun Any.w(any: Any? = "no message provided") {
    Log.w(this.javaClass.simpleName + "~", any.toString())
}

fun Any.v(any: Any? = "no message provided") {
    Log.v(this.javaClass.simpleName + "~", any.toString())
}

