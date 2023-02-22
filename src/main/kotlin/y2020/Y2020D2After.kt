package y2020

// AoC 2020 day 2 https://adventofcode.com/2020/day/2
// Del 1: hitta och räkna godkända lösenord i en lista utifrån specificerade krav
// Del 2: som ovan men med andra krav.

/*
* https://blog.jetbrains.com/kotlin/2021/07/advent-of-code-in-idiomatic-kotlin-day2/
* Idén om att göra en klass av lösenordssträngen och hur den ska parsas samt XOR.
* https://www.reddit.com/r/adventofcode/comments/k52psu/comment/gezl0qn/
* XOR samt lambdas. Även om jag använde inte använde filter och map.
*/

// För både del 1 och 2
data class PasswordBuild(
    val min: Int,
    val max: Int,
    val letter: Char,
    val password: String)

fun parseLine(line: String) = PasswordBuild(
    min = line.substringBefore("-").toInt(),
    max = line.substringAfter("-").substringBefore(" ").toInt(),
    letter = line.substringAfter(" ").substringBefore(":").single(),
    password = line.substringAfter(": ").trim()
)

// Del 1

//// Första after-versionen.
//fun validateAndCountPasswordsPt1Old(list: List<String>): Int {
//    var counter = 0
//    for (line in list) {
//        val password = parseLine(line)
//        val count = password.password.count { it == password.letter }
//        if (count in password.min..password.max) {
//            counter++
//        }
//    }
//    return counter
//}

// Final after-version
fun validateAndCountPasswordsPt1(list: List<String>): Int =
    list.count { line ->
        val pwd = parseLine(line)
        val count = pwd.password.count { it == pwd.letter }
        count in pwd.min..pwd.max
}

// Del 2
fun validateAndCountPasswordsPt2(list: List<String>): Int =
    list.count { line ->
        val pwd = parseLine(line)
        (pwd.password[pwd.min - 1] == pwd.letter) xor
                (pwd.password[pwd.max - 1] == pwd.letter)
    }


fun main() {
    // läser in textfilen till en lista med strängar
    val inputStringList = readStringFromFileToListOfString(filePathD2)
    println("Del 1: " + validateAndCountPasswordsPt1(inputStringList))
    println("Del 2: " + validateAndCountPasswordsPt2(inputStringList))
}