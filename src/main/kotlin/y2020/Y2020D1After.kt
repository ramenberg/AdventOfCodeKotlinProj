package y2020

const val filePathD1A = "src/main/resources/inputY2020D1.txt"

/*
 Har kollat på två källor till inläsningen av filen och de är nästan identiska.

 https://todd.ginsberg.com/post/advent-of-code/2020/day1/
 Denna person har först gjort en funktion för att läsa in från själva filen och sedan
 en ny funktion för att läsa från sträng till lista av ints. Eftersom jag vet att de kommande
 uppgifterna kräver att jag läser in från en fil men skapar nya listor av andra typer tyckte jag
 att lösningen med en separat funktion som enbart läser in rad för rad var smart och därför
 introducerar jag den här. Jag använder dock buffered-reader, men på ett annat sätt än i min första lösning.
*/

/*
https://lengrand.fr/advent-of-code-day-1-kotlin-til/
Hos den här personen hittade jag funktionen Triple som jag implementerade i min räknarfunktion för del 2.
Del ett använde redan funktionen för Pair och detta blev en bra fortsättning.
 */

/*
https://blog.jetbrains.com/kotlin/2021/07/advent-of-code-in-idiomatic-kotlin/
En del av denna kod är lik den jag skrev i min före-kod. Men även här används Pair och Triple.
 */

// Del 1

fun countAndMultiplyTwoEntriesThatAddTo2020(list: List<Int>, wantedNumber: Int): Int {
    return list.flatMap { i -> list.map { j -> Pair(i, j) } }
        .firstOrNull { it.first + it.second == wantedNumber }
        ?.let { it.first * it.second } ?: 0
}

fun countAndMultiplyThreeEntriesThatAddTo2020(list: List<Int>, wantedNumber: Int): Int {
    return list.flatMap { i -> list.flatMap { j -> list.map { k -> Triple(i, j, k) } } }
        .firstOrNull { it.first + it.second + it.third == wantedNumber }
        ?.let { it.first * it.second * it.third } ?: 0
}

fun main() {
    val intList = readFromFileToListOfInts(filePathD1A)

    println("Del 1: " + countAndMultiplyTwoEntriesThatAddTo2020(intList, 2020))
    println("Del 2: " + countAndMultiplyThreeEntriesThatAddTo2020(intList, 2020))
}