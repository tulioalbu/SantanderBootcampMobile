package one.digitalinnovation.collections

fun main () {
    val salarios = arrayOf(
        "2000".toBigDecimal(),
        "1500".toBigDecimal(),
        "4000".toBigDecimal()
    )


    println("----x----")
    println(salarios.somatoria())
    println("----x----")
    println(salarios.media())
}