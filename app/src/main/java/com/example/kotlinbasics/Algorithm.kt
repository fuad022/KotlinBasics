package com.example.kotlinbasics

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*
import java.util.Locale

//private var dt: String = ""

fun main() {
//    val number = 371
//    var originalNumber: Int
//    var remainder: Int
//    var result = 0
//    var n = 0
//
//    originalNumber = number
//
//    while (originalNumber != 0) {
//        originalNumber /= 10
//        ++n
//    }
//
//    originalNumber = number
//
//    while (originalNumber != 0) {
//        remainder = originalNumber % 10
//        result += Math.pow(remainder.toDouble(), n.toDouble()).toInt()
//        originalNumber /= 10
//    }
//
//    if (result == number)
//        println("$number is an Armstrong number.")
//    else
//        println("$number is not an Armstrong number.")


//    print(getWholeNum(5.19))


//    //
//    val a = 1640175988
//    val date = Instant.ofEpochSecond(a.toLong())
//            .atZone(ZoneId.systemDefault())
//            .toLocalDateTime()
//    val formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.US)
////    println(formatter.format(date))
//
//
//
//    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
//    val dateString = simpleDateFormat.format(1640175988.toLong())
//    String.format("Date: %s", dateString)
////    println(dateString)


    println(convertDate("1640526620"))
//    println(dayStringFormat(1641110400))
//    println(dayStringFormat())

//    println(getWeekDayName("2021-12-26"))

//    println(getWeekDayName("1640526620"))

    println(getWeekDayName1("1640851200"))
}

private fun convertDate(s: String): String {
    try {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val netDate = Date(s.toLong() * 1000)
        return sdf.format(netDate)
    } catch (e: Exception) {
        return e.toString()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun getWeekDayName(s: String): String {
    val dtfInput = DateTimeFormatter.ofPattern("u-M-d", Locale.US)
//    return LocalDate.parse(s, dtfInput).dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
    return LocalDate.parse(convertDate(s), dtfInput).dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH)
}

fun getWeekDayName1(s: String): String {
    val sdf = SimpleDateFormat("EEEE", Locale.US)
    val d = Date(s.toLong() * 1000)
    val dayOfTheWeek = sdf.format(d)
    return dayOfTheWeek
}

//fun convertDate(dateInMilliseconds: String, dateFormat: String): String {
//    return DateFormat.format(dateFormat, Long.parseLong(dateInMilliseconds)).toString()
//}

//private fun getWholeNum(d: Double): String {
//    val str = d.toString()
//    return when (d) {
//        in -0.9..0.0 -> str.substring(str.indexOf("-") + 1, str.indexOf("."))
//        else -> str.substringBefore('.')
//    }
//}