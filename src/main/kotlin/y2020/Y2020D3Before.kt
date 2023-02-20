package y2020

import java.io.File

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

// del 1
fun moveAndCountTrees(map: List<List<String>>): Int {
    var treeCounter = 0
    var x = 0
    var y = 0
    while (y < map.size) {
        if (map[y][x] == "#") treeCounter++
        x = (x + 3) % map[0].size
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

// del 2
fun countAndMultiplyTrees(): Int {
    val list = readFileStringTo2DList(filePathD3)
    var counter = 1
    val direction = listOf(Pair(1,1), Pair(3,1), Pair(5,1), Pair(7,1), Pair(1,2))

    for (d in direction) {
        counter *= moveAndCountTreesNo2(list, d.first, d.second)
    }
    return counter
}

fun main() {
    val list = readFileStringTo2DList(filePathD3)

    // del 1
    println( moveAndCountTrees(list))

    // del 2
    println(countAndMultiplyTrees())
}