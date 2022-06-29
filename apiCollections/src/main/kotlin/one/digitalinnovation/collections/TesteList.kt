package one.digitalinnovation.collections

fun main () {
    val Joao = funcionario ("João", 2000.0, "CLT")
    val Alberto = funcionario ("Alberto", 8000.0, "PJ")
    val Maria = funcionario ("Maria", 4000.0, "CLT")

    val funcionarios = listOf(Joao, Alberto, Maria)
    funcionarios.forEach {println(it)}

    println("----x----")
    println(funcionarios.find { it.nome == "Maria" })

    println("----x----")
    println(funcionarios.sortedBy { it.salario })

    println("----x----")
    println(funcionarios.groupBy { it.tipoContratacao })
}

