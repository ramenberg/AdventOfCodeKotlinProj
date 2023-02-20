package y2020

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Y2020D2AfterKtTest {

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

        val actualResult = validateAndCountPasswordsPt1(testList)

        assertEquals(expectedResult, actualResult)
    }

    // Del 2
    @Test
    fun validateAndCountPasswordsPt2CheckCorrectNoOfValidPwds() {
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

        val actualResult = validateAndCountPasswordsPt2(testList)

        assertEquals(expectedResult, actualResult)
    }

}