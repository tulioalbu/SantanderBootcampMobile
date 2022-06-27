import java.util.*

fun main () {
    val reader = Scanner(System.`in`)
    println("Coloque o primeiro número que você deseja operar: ")
    val n1 = reader.nextDouble()

    println("Coloque a operação que você deseja fazer:")
    println("+ para somar")
    println("- para subtrair")
    println("* para multiplicar")
    println("/ para dividir")
    println("p para potenciação")
    println("r para radiciação")
    val operador = reader.next()[0]


    println("Coloque o segundo número que você deseja operar")
    val n2 = reader.nextDouble()


    val result:Double

    when (operador) {
        '+' -> result = n1 + n2
        '-' -> result = n1 - n2
        '*' -> result = n1 * n2
        '/' -> result = n1 / n2
        'p' -> result = Math.pow(n1,n2)
        'r' -> result = Math.pow(n1, 1.0 / n2)
        else -> {
            println("Erro!")
            return
        }
    }

    println("$n1 $operador $n2 = $result")
}

