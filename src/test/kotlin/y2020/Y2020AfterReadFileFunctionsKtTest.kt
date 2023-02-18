package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Y2020AfterReadFileFunctionsKtTest {

    private val testFilePath = "src/test/resources/testInput.txt"

    @Test
    fun readStringFromFileToListOfStringCheckValues() {
        val expectedList = listOf("1632", "1438", "1811", "1943", "1883", "1698")
        val testFile = File(testFilePath)
        testFile.writeText(
            "1632\n" +
                    "1438\n" +
                    "1811\n" +
                    "1943\n" +
                    "1883\n" +
                    "1698")

        val resultList = readStringFromFileToListOfString(testFilePath)

        assertEquals(expectedList, resultList)
    }

    @Test
    fun readStringFromFileToListOfStringCheckSize() {
        val expectedListSize = 8
        val testFile = File(testFilePath)
        testFile.writeText(
            "1632\n" +
                    "1438\n" +
                    "1811\n" +
                    "1943\n" +
                    "1883\n" +
                    "1698\n" +
                    "1976\n" +
                    "1972") // 8 entries

        val resultList = readStringFromFileToListOfString(testFilePath)

        assertEquals(expectedListSize, resultList.size)
    }
}