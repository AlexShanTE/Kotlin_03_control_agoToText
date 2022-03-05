fun main() {

val seconds1 = 3066L            // 61 - 3599 минуту
val seconds2 = 3006L            // 61 - 3599 минут
val seconds3 = 122L            // 61 - 3599 минуты
val seconds4 = 18001L            // 3600 - 86400  часов
val seconds5 = 79199L           // 3600 - 86400  час
val seconds6 = 79200L           // 3600 - 86400  часа
val seconds7 = 130000L
val seconds8 = 345000L
val seconds9 = 100000000000L

println(agoToText(seconds1))
println(agoToText(seconds2))
println(agoToText(seconds3))
println(agoToText(seconds4))
println(agoToText(seconds5))
println(agoToText(seconds6))
println(agoToText(seconds7))
println(agoToText(seconds8))
println(agoToText(seconds9))
}

fun agoToText(seconds: Long):String{
    return when (seconds) {
        in 0..60 -> "был(а) только что"
        in 61..3599 -> "был(а) ${(seconds / 60)} ${minuteToTextConverter(seconds)} назад"
        in 3600..86400 -> "был(а) ${(seconds / 3600)} ${hourToTextConverter(seconds)} назад"
        in 86401..172800 -> "был(а) сегодня"
        in 172801..345600 -> "был(а) вчера"
        else -> "был(а) давно"
    }
}

fun minuteToTextConverter (seconds: Long): String {
    val minutes = (seconds / 60)
    return if (minutes in 11..14){
        "минут"
    } else {
        when (minutes % 10) {
            1L -> "минуту"
            2L, 3L, 4L -> "минуты"
            else -> "минут"
        }
    }
}

fun hourToTextConverter (seconds: Long): String {
    val hours = (seconds / 3600)
    return if (hours in 11..14){
        "часов"
    } else {
        when (hours % 10) {
            1L -> "час"
            2L, 3L, 4L -> "часа"
            else -> "часов"
        }
    }
}