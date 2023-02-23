fun agoToText(secondsAgo: Int): String {
    return when {
        secondsAgo <= 60 -> "был(а) только что"
        secondsAgo <= 60 * 60 -> "${minutesAgoText(secondsAgo)} назад"
        secondsAgo <= 24 * 60 * 60 -> "${hoursAgoText(secondsAgo)} назад"
        secondsAgo <= 2 * 24 * 60 * 60 -> "вчера"
        secondsAgo <= 3 * 24 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
}

// Вспомогательная функция, которая возвращает строку с количеством минут
fun minutesAgoText(secondsAgo: Int): String {
    val minutesAgo = secondsAgo / 60
    return when {
        minutesAgo == 1 || minutesAgo % 10 == 1 -> "$minutesAgo минуту"
        minutesAgo in 2..4 || minutesAgo % 10 in 2..4 -> "$minutesAgo минуты"
        else -> "$minutesAgo минут"
    }
}

// Вспомогательная функция, которая возвращает строку с количеством часов
fun hoursAgoText(secondsAgo: Int): String {
    val hoursAgo = secondsAgo / (60 * 60)
    return when {
        hoursAgo == 1 || hoursAgo % 10 == 1 -> "$hoursAgo час"
        hoursAgo in 2..4 || hoursAgo % 10 in 2..4 -> "$hoursAgo часа"
        else -> "$hoursAgo часов"
    }
}

// Тестирование функции agoToText с разными значениями входного параметра
fun main() {
    println(agoToText(10)) // был(а) только что
    println(agoToText(125)) // 2 минуты назад
    println(agoToText(3700)) // 1 час назад
    println(agoToText(93600)) // вчера
    println(agoToText(259200)) // позавчера
    println(agoToText(864000)) // давно
}
