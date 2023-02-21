package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Y2020D1Test {

    @Test
    fun testReadFile() {
        val expectedList = listOf(1, 2, 3, 4, 5)
        val testFilePath = "src/test/resources/testInput.txt"
        val testFile = File(testFilePath)
        testFile.writeText("1\n2\n3\n4\n5")

        val resultList = readFile(testFilePath)

        assertEquals(expectedList, resultList)
    }
    @Test
    fun testReadFileListSize() {
        val expectedListSize = 5
        val testFilePath = "src/test/resources/testInput.txt"
        val testFile = File(testFilePath)
        testFile.writeText("1\n2\n3\n4\n5") // 5 entries = size 5

        val resultList = readFile(testFilePath)

        assertEquals(expectedListSize, resultList.size)
    }

    @Test
    fun findTwoNumbers() {
        // hitta två siffror som adderar till 2020
        val testList = listOf(1900, 1905, 1920, 105, 120) // första och sista
        val expectedList = listOf(1900, 120)
        val resultList = findTwoNumbers(testList)
        assertEquals(expectedList, resultList)
    }

    @Test
    fun multiplyTwoNumbers() {
        val testList = listOf(1900, 120)
        val expected = 228_000
        val result = multiplyTwoNumbers(testList)
        assertEquals(expected, result)
    }

    @Test
    fun findThreeNumbers() {
        val testList = listOf(1900, 1905, 1920, 105, 15) // första och två sista
        val expected = listOf(1900, 105, 15)
        val result = findThreeNumbers(testList)
        assertEquals(expected, result)
    }

    @Test
    fun multiplyThreeNumbers() {
        val testList = listOf(1900, 105, 15)
        val expected = 2_992_500
        val result = multiplyThreeNumbers(testList)
        assertEquals(expected, result)
    }

    // After

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