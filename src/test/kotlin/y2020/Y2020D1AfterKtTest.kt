package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Y2020D1AfterKtTest {


    private val testFilePath = "src/test/resources/testInput.txt"

    @Test
    fun countAndMultiplyTwoEntriesThatAddTo2020CheckList() {
        val expectedNumber = 96
        val testList = listOf(8, 12, 23, 45, 96, 29)

        val result = countAndMultiplyTwoEntriesThatAddTo2020(testList, 20)

        assertEquals(expectedNumber, result)
    }

    @Test
    fun countAndMultiplyThreeEntriesThatAddTo2020() {
        val expectedNumber = 48
        val testList = listOf(33, 75, 3, 22, 16, 1)

        val result = countAndMultiplyThreeEntriesThatAddTo2020(testList, 20)

        assertEquals(expectedNumber, result)
    }
}