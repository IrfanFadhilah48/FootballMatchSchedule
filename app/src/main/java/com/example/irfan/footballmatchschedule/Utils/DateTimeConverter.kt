package com.example.irfan.footballmatchschedule.Utils

import java.text.SimpleDateFormat

object DateTimeConverter{

    fun formatDate(date : String, format : String) : String{
        var convert = ""
        val old = SimpleDateFormat("yyyy-MM-dd")

        val Date = old.parse(date)
        val newFormat = SimpleDateFormat(format)

        convert = newFormat.format(Date)
        return convert
    }

    fun longDate(date: String) : String{
        return formatDate(date, "EEE , dd MMMMM yyyy")
    }
}