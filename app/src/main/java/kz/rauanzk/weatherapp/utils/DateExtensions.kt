package kz.rauanzk.weatherapp.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun Long.format(): String {
    val date = Date(this)
    return SimpleDateFormat("dd.MM.yy, HH:mm:ss").format(date)
}