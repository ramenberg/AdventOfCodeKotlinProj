package y2020

import java.io.File

// För alla dagar i "After"
// inspiration från https://todd.ginsberg.com/post/advent-of-code/2020/day1/

// Läser från filen och skapar lista med strängar.
fun readStringFromFileToListOfString(fileName: String): List<String> = File(fileName)
    .bufferedReader()
    .use { it.readLines() }

// Dag 1
// Använder föregående funktion för att skapa en lista med Ints från listan med String.
fun readFromFileToListOfInts(fileName: String): List<Int> =
    readStringFromFileToListOfString(fileName)
    .map { it.toInt() }

// Dag 3
// Använder föregående funktion för att skapa en map av listor av strängar.
fun readFromFileToMapOfStrings(fileName: String): List<List<String>> =
    readStringFromFileToListOfString(fileName)
    .map { it -> it.toList().map { it.toString() } }
