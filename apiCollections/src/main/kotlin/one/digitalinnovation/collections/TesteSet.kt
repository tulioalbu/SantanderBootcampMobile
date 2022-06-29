package one.digitalinnovation.collections

fun main () {
    val Joao = funcionario("João", 2000.0, "CLT")
    val Alberto = funcionario("Alberto", 8000.0, "PJ")
    val Maria = funcionario("Maria", 4000.0, "CLT")

    val funcionarios1 = setOf(Joao, Maria)
    val funcionarios2 = setOf(Alberto)


    val resultUnion = funcionarios1.union(funcionarios2)
    resultUnion.forEach { println(it) }

    println("----x----")
    val funcionarios3 = setOf(Joao, Maria, Alberto)
    val resultSubstract = funcionarios3.subtract(funcionarios1)
    resultSubstract.forEach { println(it) }

    println("----x----")
    val resultIntersect = funcionarios3.intersect(funcionarios1)
    resultIntersect.forEach { println(it) }

}




