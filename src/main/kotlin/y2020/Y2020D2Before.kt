package y2020

import java.io.File
import java.io.InputStream

// AoC 2020 day 2 https://adventofcode.com/2020/day/2
// Del 1: hitta och räkna godkända lösenord i en lista utifrån specificerade krav
// Del 2: som ovan men med andra krav.

// För båda delarna
fun readFileString(filePath: String): List<String> {
    val buff: InputStream = File(filePath).inputStream()
    val listOfPwd = mutableListOf<String>()

    buff.buffered().reader().use { reader ->
        reader.forEachLine { line ->
            listOfPwd.add(line)
        }
    }
    return listOfPwd
}
// Del 1
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

// Del 2
fun checkValidPwdPosition(list: List<String>): Int {
    var counter = 0
    // exempelkod 1-3 a: abcde
    for (i in list) {
        val splitString = i.split(" ") // ger 1-3, a:, abcde
        val minMax = splitString[0].split("-") // 1, 3
        val pos1 = minMax[0].toInt() - 1 // 1. minus 1 pga index börjar på 0
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