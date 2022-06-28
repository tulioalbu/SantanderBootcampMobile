package one.digitalinnovation.collections

fun main () {
    val salarios = DoubleArray(3)
    salarios[0] = 1000.0
    salarios[1] = 2000.0
    salarios[2] = 3000.0

    salarios.forEach {
        println(it)
    }

    println("----x----")

    salarios.forEachIndexed {index, salario ->

        salarios[index] = salario * 1.1
    }

    salarios.forEach {
        println(it)
    }

    println("----x----")

    val salarios2 = doubleArrayOf(1350.0, 2240.5, 3990.5)
    salarios2.sort()
    salarios2.forEach {
        println(it)
    }

}