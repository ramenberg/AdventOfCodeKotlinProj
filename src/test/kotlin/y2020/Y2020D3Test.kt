package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Y2020D3Test {

    private val testFilePath = "src/test/resources/testInput.txt"
    @Test
    fun readFileStringTo2DListCorrectReadAndTransform() {
        val expectedList = listOf(
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", "#", ".", "."),
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", "#", ".", "."),
        )
        val testFile = File(testFilePath)
        testFile.writeText(
            "...#.\n" +
                    "...#.\n" +
                    "..#..\n" +
                    "...#.\n" +
                    "...#.\n" +
                    "..#.."
        )
        val resultList = readFileStringTo2DList(testFilePath)
        assertEquals(expectedList, resultList)
    }

    @Test
    fun readFileStringTo2DListCorrectReadAndTransformShouldBeCorrectSize() {
        val testFile = File(testFilePath)
        testFile.writeText(
            "...#.\n" +
                    "...#.\n" +
                    "..#..\n" +
                    "...#.\n" +
                    "...#.\n" +
                    "..#.."
        )
        val expectedSize = 6
        val resultList = readFileStringTo2DList(testFilePath)
        assertEquals(expectedSize, resultList.size)
    }

    @Test
    fun moveAndCountTreesShouldBeEquals() {
        val testFile = File(testFilePath)
        testFile.writeText(
            "...#.\n" +
                    "...#.\n" +
                    "..#..\n" +
                    "...#.\n" +
                    "...#.\n" +
                    "..#.."
        )

        val expectedValue = 1
        val resultList = readFileStringTo2DList(testFilePath)
        val result = moveAndCountTrees(resultList)
        assertEquals(expectedValue, result)
    }
    @Test
    fun moveAndCountTreesShouldNotBeEquals() {
        val expectedValue = 6 // The amount times NO. is written to the test file.
        val testFilePath = "src/test/resources/testInput.txt"
        val testFile = File(testFilePath)
        testFile.writeText(
            "...#.\n" +
                    "...#.\n" +
                    "..#..\n" +
                    "...#.\n" +
                    "...#.\n" +
                    "..#.."
        )
        val resultList = readFileStringTo2DList(testFilePath)
        val result = moveAndCountTrees(resultList)
        assertNotEquals(expectedValue, result)
    }

    @Test
    fun moveAndCountTreesNo2Pair1() {
        val pairs = listOf(Pair(1,1))
        val testFile = File(testFilePath)
        testFile.writeText(
            "...#.\n" +
                    "...#.\n" +
                    "..#..\n" +
                    "...#.\n" +
                    "...#.\n" +
                    "..#.."
        )
        val expectedValue = 2
        val resultList = readFileStringTo2DList(testFilePath)
        val result = moveAndCountTreesNo2(resultList, pairs[0].first, pairs[0].second)
        assertEquals(expectedValue, result)
    }
    @Test
    fun moveAndCountTreesNo2Pair2() {
        val pairs = listOf(Pair(1,2))
        val testFile = File(testFilePath)
        testFile.writeText(
            "...#.\n" +
                    "...#.\n" +
                    "..#..\n" +
                    "...#.\n" +
                    "...#.\n" +
                    "..#.."
        )
        val expectedValue = 0
        val resultList = readFileStringTo2DList(testFilePath)
        val result = moveAndCountTreesNo2(resultList, pairs[0].first, pairs[0].second)
        assertEquals(expectedValue, result)
    }

    @Test
    fun countTreesAfterTestShouldBeEqual() {

        val testMap = listOf(
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", ".", "#", "."),
            listOf(".", "#", "#", ".", "."),
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", "#", ".", "."),
        )

        val expectedValue = 2

        val result = countTreesAfter(testMap, 3, 1)

        assertEquals(expectedValue, result)
    }
    @Test
    fun countTreesAfterTestShouldBeNotEqual() {

        val testMap = listOf(
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", ".", ".", "."),
            listOf(".", "#", ".", ".", "."),
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", ".", "#", "."),
            listOf(".", ".", "#", ".", "."),
        )

        val expectedValue = 5

        val result = countTreesAfter(testMap, 3, 1)

        assertNotEquals(expectedValue, result)
    }
}