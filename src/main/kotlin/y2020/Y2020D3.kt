package y2020

import java.io.File

const val filePathD3 = "src/main/resources/inputY2020D3.txt"

fun readFileStringTo2DList(file: String): List<List<String>> {
    val rows = File(file).readLines()
    val charList = mutableListOf<List<String>>()

    for (row in rows) {
        val charListRow = mutableListOf<String>()
        for (char in row) {
            charListRow.add(char.toString())
        }
        charList.add(charListRow)
    }
    return charList
}

fun moveAndCountTrees(map: List<List<String>>): Int {
    var treeCounter = 0
    var x = 0
    var y = 0
    while (y < map.size) {
        if (map[y][x] == "#") treeCounter++
        x = (x + 3) % map[0].size
        println(x)
        y += 1
    }
    return treeCounter
}

// part 2
fun moveAndCountTreesNo2(map: List<List<String>>, right: Int, down: Int): Int {
    var treeCounter = 0
    var x = 0
    var y = 0
    while (y < map.size) {
        if (map[y][x] == "#") treeCounter++
        x = (x + right) % map[0].size
        y += down
    }
    return treeCounter
}

fun main() {
    val list = readFileStringTo2DList(filePathD3)
    println( moveAndCountTrees(list))
}