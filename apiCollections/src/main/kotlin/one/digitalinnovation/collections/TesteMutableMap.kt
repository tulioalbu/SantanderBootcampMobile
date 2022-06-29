package one.digitalinnovation.collections

fun main () {
    val Joao = funcionario("João", 2000.0, "CLT")
    val Alberto = funcionario("Alberto", 8000.0, "PJ")
    val Maria = funcionario("Maria", 4000.0, "CLT")

    val repositorio = Repositorio<funcionario>()

    repositorio.create(Joao.nome, Joao)
    repositorio.create(Alberto.nome, Alberto)
    repositorio.create(Maria.nome, Maria)

    println(repositorio.findById(Maria.nome))

    println("----x----")
    repositorio.findAll().forEach() { println(it)}

    println("----x----")
    repositorio.remove(Maria.nome)
    repositorio.findAll().forEach() { println(it)}


}