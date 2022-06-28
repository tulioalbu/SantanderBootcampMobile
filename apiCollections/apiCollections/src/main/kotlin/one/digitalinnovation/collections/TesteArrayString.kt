package one.digitalinnovation.collections

fun main() {
    val nomes = Array<String>(3) {""}
    nomes [0] = "Túlio"
    nomes [1] = "Joaline"
    nomes [2] = "Santiago"

    for (i in nomes) {
        println (i)
    }

    println("----x----")
    nomes.sort()
    nomes.forEach {
        println(it)
    }

    val nomes2 = arrayOf("Túlio", "Joaline", "Santiago", "Acácia")

    println("----x----")
    nomes2.sort()
    nomes2.forEach {
        println(it)
    }

}