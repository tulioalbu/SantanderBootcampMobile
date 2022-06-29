package one.digitalinnovation.collections

fun main () {
    val Joao = funcionario("João", 2000.0, "CLT")
    val Alberto = funcionario("Alberto", 8000.0, "PJ")
    val Maria = funcionario("Maria", 4000.0, "CLT")

    println("----LIST----")
    val funcionarios = mutableListOf(Joao, Maria)
    funcionarios.forEach{ println(it) }

    println("----x----")
    funcionarios.add(Alberto)
    funcionarios.forEach{ println(it) }

    println("----x----")
    funcionarios.remove(Joao)
    funcionarios.forEach{ println(it) }

    println("----SET----")
    val funcionariosSet = mutableSetOf(Joao)
    funcionariosSet.forEach{ println(it) }

    println("----x----")
    funcionariosSet.add(Alberto)
    funcionariosSet.add(Maria)
    funcionariosSet.forEach{ println(it) }

    println("----x----")
    funcionariosSet.remove(Alberto)
    funcionariosSet.forEach{ println(it) }
}