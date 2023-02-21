package y2020


/*
Dag 3
https://adventofcode.com/2020/day/3

Mest för del 2. Bl.a. för multiplikationen.
https://todd.ginsberg.com/post/advent-of-code/2020/day3/
https://lengrand.fr/advent-of-code-day-3-kotlin-til/

Nedan är Rust men kollade på övergripande syntax.
https://dev.to/rpalo/advent-of-code-2020-solution-megathread-day-3-toboggan-trajectory-i47
 */

data class Slope(
    val right: Int,
    val down: Int
    )

fun countTreesAfter(map: List<List<String>>, slope: Slope): Int {
    val (right, down) = slope
    val width = map[0].size
    val height = map.size

    val isTree = { x: Int, y: Int -> map[y][x % width] == "#" }

    return (0 until height step down)
        .count { isTree(right * it, it)
    }
}

// Del 2
fun multiplyTreesAfter(map: List<List<String>>, slopes: List<Slope>): Long {
    return slopes
        .map { countTreesAfter(map, it).toLong() }
        .reduce { a, b -> a * b }
}


fun main() {
    val mappedList = readFromFileToMapOfStrings(filePathD3)

    // Del 1
    val slopePt1 = Slope(3, 1)

    val resultPt1 = countTreesAfter(mappedList, slopePt1)
    println("Del 1: $resultPt1")

    // Del 2
    val slopes = listOf(
        Slope(1, 1),
        Slope(3, 1),
        Slope(5, 1),
        Slope(7, 1),
        Slope(1, 2)
    )
    val resultPt2 = multiplyTreesAfter(mappedList, slopes)
    println("Del 2: $resultPt2")
}