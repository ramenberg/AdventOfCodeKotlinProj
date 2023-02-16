package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Y2020D3KtTest {

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
        assertEquals(expectedList, resultList)
    }

    @Test
    fun readFileStringTo2DListCorrectReadAndTransformShouldBeCorrectSize() {
        val expectedSize = 6
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
        assertEquals(expectedSize, resultList.size)
    }
}