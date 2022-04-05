package ru.netology

fun main() {

    println(agoToText(30))
    println(agoToText(2_500))
    println(agoToText(10_500))
    println(agoToText(100_500))
    println(agoToText(195_900))
    println(agoToText(350_700))

}

private fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "был (а) только что"
        in 61..60 * 60 -> "был(а) ${endingWord(seconds, false)}"
        in 60 * 60 + 1..24 * 60 * 60 -> "был(а) в сети ${endingWord(seconds, true)}"
        in 24 * 60 * 60 + 1..48 * 60 * 60 -> "был(а) в сети сегодня"
        in 48 * 60 * 60 + 1..72 * 60 * 60 -> "был(а) в сети вчера"
        else -> "был(а) в сети давно"
    }

}


private fun endingWord(seconds: Int, isHour: Boolean): String {
    val time = if (isHour) seconds / (60 * 60) else seconds / 60
    val remains = time % 10
    return when {
        remains == 1 && time / 10 != 1 -> if (isHour) "$time час назад" else "$time минуту назад"
        remains in 2..4 && time / 10 != 1 -> if (isHour) "$time часа назад" else "$time минуты назад"
        else -> if (isHour) "$time часов назад" else "$time минут назад"
    }

}



