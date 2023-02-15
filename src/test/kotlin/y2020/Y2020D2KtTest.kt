package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Y2020D2KtTest {

    @Test
    fun readFileString() {
        val expectedList = listOf("hej", "ja", "nej")
        val testFilePath = "src/test/resources/testInput.txt"
        val testFile = File(testFilePath)
        testFile.writeText("hej\nja\nnej")

        val resultList = readFile(testFilePath)

        assertEquals(expectedList, resultList)
    }
}