package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Y2020D2Test {

    private val testList10Entries = listOf(
        "3-4 j: jjjjj",
        "3-4 c: fbhnsccbc",
        "2-4 q: thql",
        "15-18 w: tcwzpwzfwwqftvczbw",
        "5-7 l: lblwblbmllqnlbl",
        "3-4 b: bvbfnbb",
        "4-5 f: ffgzf",
        "7-9 c: cctcccccc",
        "5-6 k: szkgsk",
        "2-5 n: nqvnmgnqnsxfn"
    )

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

    // Del 1
    @Test
    fun checkValidPasswordsPt1() {
        val expectedResult = 5

        val actualResult = checkValidPwd(testList10Entries)

        assertEquals(expectedResult, actualResult)
    }

    // Del 2
    @Test
    fun checkValidPasswordsPt2() {
        val expectedResult = 4

        val actualResult = checkValidPwdPosition(testList10Entries)

        assertEquals(expectedResult, actualResult)
    }

    // After

    @Test
    fun parseLineFirstTestShouldBeEqual() {
        val testString = "13-17 s: ssssssssssssgsssj"
        val expectedResult = PasswordBuild(13, 17, 's', "ssssssssssssgsssj")


        val actualResult = parseLine(testString)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun parseLineSecondTestShouldBeEqual() {
        val testString = "7-9 p: pnlzhcppvl"
        val expectedResult = PasswordBuild(7, 9, 'p', "pnlzhcppvl")

        val actualResult = parseLine(testString)

        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun parseLineTestShouldNotBeEqual() {
        val testString = "13-17 s: ssssssssssssgsssj"
        val expectedResult = PasswordBuild(13, 15, 'j', "sssssssssssgsssj")

        val actualResult = parseLine(testString)

        assertNotEquals(expectedResult, actualResult)
    }

    // Del 1
    @Test
    fun validateAndCountPasswordsPt1CheckCorrectNoOfValidPwds() {
        val expectedResult = 5

        val actualResult = validateAndCountPasswordsPt1(testList10Entries)

        assertEquals(expectedResult, actualResult)
    }

    // Del 2
    @Test
    fun validateAndCountPasswordsPt2CheckCorrectNoOfValidPwds() {
        val expectedResult = 4

        val actualResult = validateAndCountPasswordsPt2(testList10Entries)

        assertEquals(expectedResult, actualResult)
    }
}