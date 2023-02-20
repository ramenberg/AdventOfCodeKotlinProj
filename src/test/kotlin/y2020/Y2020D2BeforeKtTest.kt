package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Y2020D2BeforeKtTest {

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
        val testList = listOf(
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

        val actualResult = checkValidPwd(testList)

        assertEquals(expectedResult, actualResult)
    }

    // Del 2
    @Test
    fun checkValidPasswordsPt2() {
        val expectedResult = 4
        val testList = listOf(
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

        val actualResult = checkValidPwdPosition(testList)

        assertEquals(expectedResult, actualResult)
    }
}