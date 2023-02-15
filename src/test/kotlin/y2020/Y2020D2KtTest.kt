package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Y2020D2KtTest {

    @Test
    fun testReadFileString() {
        val expectedList = listOf("kalle", "pelle", "olle", "johan", "jens")
        val testFilePath = "src/test/resources/testInput.txt"
        val testFile = File(testFilePath)
        testFile.writeText("kalle\npelle\nolle\njohan\njens")

        val resultList = readFileString(testFilePath)

        assertEquals(expectedList, resultList)
    }
    @Test
    fun testReadFileStringListSize() {
        val expectedListSize = 5
        val testFilePath = "src/test/resources/testInput.txt"
        val testFile = File(testFilePath)
        testFile.writeText("kalle\npelle\nolle\njohan\njens") // 5 entries = size 5

        val resultList = readFileString(testFilePath)

        assertEquals(expectedListSize, resultList.size)
    }
}