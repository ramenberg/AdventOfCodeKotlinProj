package y2020

import java.io.File

// För alla dagar
// Läser från filen och skapar lista med strängar.
fun readStringFromFileToListOfString(file: String): List<String> = File(file)
    .bufferedReader()
    .use { it.readLines() }

// Dag 1
// Använder föregående funktion för att skapa en lista med Ints från listan med String.
fun readFromFileToListOfInts(file: String): List<Int> = readStringFromFileToListOfString(file)
    .map { it.toInt() }

// Dag 2
