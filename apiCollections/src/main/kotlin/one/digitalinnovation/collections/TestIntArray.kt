package one.digitalinnovation.collections

fun main () {
    val values = IntArray(5)

    values [0] = 1
    values [1] = 7
    values [2] = 6
    values [3] = 3
    values [4] = 2

    for (i in values) {
        println(i)
    }

    println("----x----")
    values.forEach {
        println(it)
    }

    println("----x----")
    for (index in values.indices)
        println(values[index])

    println("----x----")
    values.sort()
    for (i in values) {
        println(i)
    }

}