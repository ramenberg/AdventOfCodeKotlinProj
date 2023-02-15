package y2020
import java.io.File
import java.io.InputStream


const val filePathD1 = "src/main/resources/inputY2020D1.txt"
// Part 1
fun readFile(file: String): List<Int> {
    val buff: InputStream = File(file).inputStream()
    val listOfInts = mutableListOf<Int>()

    buff.buffered().reader().use { reader ->
        reader.forEachLine { line ->
            listOfInts.add(line.toInt())
        }
    }
    return listOfInts
}
fun findTwoNumbers(list: List<Int>): List<Int> {
    val listWithTheTwoNumbers = mutableListOf<Int>()
    // find the two numbers that add up to 2020
    for (i in list) {
        for (j in list) {
            if (i + j == 2020) {
                listWithTheTwoNumbers.add(i)
                listWithTheTwoNumbers.add(j)
                return listWithTheTwoNumbers
            }
        }
    }
    return listWithTheTwoNumbers
}

fun multiplyTwoNumbers(list: List<Int>): Int {
    return list[0] * list[1]
}

// part 2

// find 3 numbers that add up to 2020
fun findThreeNumbers(list: List<Int>): List<Int> {
    val listWithThreeNumbers = mutableListOf<Int>()
    // find the three numbers that add upp to 2020
    for (i in list) {
        for(j in list) {
            for (k in list) {
                if (i + j + k == 2020) {
                    listWithThreeNumbers.add(i)
                    listWithThreeNumbers.add(j)
                    listWithThreeNumbers.add(k)
                    return listWithThreeNumbers
                }
            }
        }
    }
    return listWithThreeNumbers
}

fun multiplyThreeNumbers(list: List<Int>): Int {
    return list[0] * list[1] * list[2]
}


fun main() {
    // part 1
    val listOfInts = readFile(filePathD1)

    if (listOfInts.isNotEmpty()) {
        val secondList = findTwoNumbers(listOfInts)
        if (secondList.isNotEmpty()) {
            println("Pt1: " + multiplyTwoNumbers(secondList))
        }
    }

    // part 2
    if (listOfInts.isNotEmpty()) {
        val threeList = findThreeNumbers(listOfInts)
        println(threeList.size)
        if (threeList.isNotEmpty()) {
            println("Pt2: " + multiplyThreeNumbers(threeList))
        }
    }
}