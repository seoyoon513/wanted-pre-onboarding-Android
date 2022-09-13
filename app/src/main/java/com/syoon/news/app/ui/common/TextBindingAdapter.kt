package com.syoon.news.app.ui.common

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("timeDiff")
fun timeDiff(textView: TextView, time: String) {

    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val curTime = System.currentTimeMillis()

    val publishTime = format.parse(changeTimeFormat(time)).time
    var diff: Long = (curTime - publishTime) / 1000

    if (diff < TimeValue.SEC.value)
        textView.text = "Just Before"
    else {
        for (i in TimeValue.values()) {
            diff /= i.value
            if (diff < i.maximum) {
                when (i.msg) {
                    "SEC" -> textView.text = "$diff minutes ago"
                    "MIN" -> textView.text = "$diff hours ago"
                    "HOUR" -> textView.text = "$diff days ago"
                    "DAY" -> textView.text = "$diff months ago"
                    "MONTH" -> textView.text = "$diff years ago"
                }
                break
            }
        }
    }
}

fun changeTimeFormat(time: String): String {
    try {
        val oldFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val newFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val oldTime = oldFormat.parse(time)
        return newFormat.format(oldTime)
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return ""

}

enum class TimeValue(val value: Int, val maximum: Int, val msg: String) {
    SEC(60, 60, "SEC"),
    MIN(60, 24, "MIN"),
    HOUR(24, 30, "HOUR"),
    DAY(30, 12, "DAY"),
    MONTH(12, Int.MAX_VALUE, "MONTH")
}