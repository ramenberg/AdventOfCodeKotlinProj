package y2020

import java.io.File
import java.io.InputStream

const val filePathD2 = "src/main/resources/inputY2020D2.txt"

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

fun main() {
    println(readFileString(filePathD2).size)
}