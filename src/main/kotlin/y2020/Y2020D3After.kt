package y2020


fun countTreesAfter(map: List<List<String>>, right: Int, down: Int): Int {
    val width = map[0].size
    val height = map.size
    val isTree = { x: Int, y: Int -> map[y][x] == "#" }
    return (0 until height step down).count { y ->
        isTree((y / down * right) % width, y)
    }
}

fun main() {
    val mappedList = readFromFileToMapOfStrings(filePathD3)

}