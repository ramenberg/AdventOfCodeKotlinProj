package y2020
import java.io.File
import java.io.InputStream

const val filePathD1 = "src/main/resources/inputY2020D1.txt"

// Del 1
fun readFile(file: String): List<Int> {
    val buff: InputStream = File(file).inputStream()
    val listOfInts = mutableListOf<Int>()

    buff.buffered().reader().use { reader ->
        reader.forEachLine { line ->
            val number = line.toIntOrNull()
            if (number != null) {
                listOfInts.add(number)
            }
            else {
                println("Error: $line is not a valid integer.")
            }
        }
    }
    return listOfInts
}

// hitta två nummer som adderar till 2020
fun findTwoNumbers(list: List<Int>): List<Int> {
    val listWithTheTwoNumbers = mutableListOf<Int>()
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

// Del 2

// hitta tre nummer som adderar till 2020
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
    // Del 1
    val listOfInts = readFile(filePathD1)

    if (listOfInts.isNotEmpty()) {
        val secondList = findTwoNumbers(listOfInts)

        if (secondList.isNotEmpty()) {
            println("Del 1: " + multiplyTwoNumbers(secondList))
        }
    }

    // Del 2
    if (listOfInts.isNotEmpty()) {
        val threeList = findThreeNumbers(listOfInts)

        if (threeList.isNotEmpty()) {
            println("Del 2: " + multiplyThreeNumbers(threeList))
        }
    }
}