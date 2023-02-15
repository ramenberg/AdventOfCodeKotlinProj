package y2020

import java.io.File
import java.io.InputStream

const val filePathD2 = "src/main/resources/inputY2020D2.txt"

// Part 1
fun readFileString(file: String): List<String> {
    val buff: InputStream = File(file).inputStream()
    val listOfPwd = mutableListOf<String>()

    buff.buffered().reader().use { reader ->
        reader.forEachLine { line ->
            listOfPwd.add(line)
        }
    }
    return listOfPwd
}
fun checkValidPwd(list: List<String>): Int {
    var counter = 0
    // exempelkod 1-3 a: abcde
    for (i in list) {
        val splitString = i.split(" ") // ger 1-3, a:, abcde
        val minMax = splitString[0].split("-")
        val min = minMax[0].toInt() // 1
        val max = minMax[1].toInt() // 3
        val letter = splitString[1].substring(0, 1) // tar bort :
        val pwd = splitString[2] // abcde

        var count = 0
        for (char in pwd) {
            if (char.toString() == letter) {
                count++
            }
        }
        if (count in min..max) {
            counter++
        }
    }
    return counter
}

// part 2

fun checkValidPwdPosition(list: List<String>): Int {
    var counter = 0
    // exempelkod 1-3 a: abcde
    for (i in list) {
        val splitString = i.split(" ") // ger 1-3, a:, abcde
        val minMax = splitString[0].split("-")
        val pos1 = minMax[0].toInt() - 1 // 1
        val pos2 = minMax[1].toInt() - 1 // 3
        val letter = splitString[1].substring(0, 1) // tar bort :
        val pwd = splitString[2] // abcde

        if (pwd[pos1].toString() == letter && pwd[pos2].toString() != letter) {
            counter++
        } else if (pwd[pos1].toString() != letter && pwd[pos2].toString() == letter) {
            counter++
        }
    }
    return counter
}
fun main() {
    // part 1
    val listOfPwd = readFileString(filePathD2)
    val validPwd = checkValidPwd(listOfPwd)
    println("Antal giltiga lösenord i första delen: $validPwd")
    val validPwdPosition = checkValidPwdPosition(listOfPwd)
    println("Antal giltiga lösenord i andra delen: $validPwdPosition")
}