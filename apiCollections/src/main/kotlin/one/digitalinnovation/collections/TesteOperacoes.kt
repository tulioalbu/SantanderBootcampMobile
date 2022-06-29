package one.digitalinnovation.collections

fun main () {
    val salarios = doubleArrayOf(4000.0, 7500.0, 9000.0, 9842.0)

    for (i in salarios) {
        println(i)
    }

    println("----x----")
    println("Maior Salário: ${salarios.maxOrNull()}")
    println("Menor Salário: ${salarios.minOrNull()}")
    println("Média dos Salários: ${salarios.average()}")

    val salariosMaiorQue9000 = salarios.filter { it > 4500.0 }

    println("----x----")
    salariosMaiorQue9000.forEach {
        println("Salários maiores que 9000: $it")
    }

    println("----x----")
    println(salarios.count { it in 8000.0 .. 10000.0  })

    println("----x----")
    println(salarios.find { it == 4000.00  })
    println(salarios.find { it == 523.00  })

    println("----x----")
    println(salarios.any { it == 4000.00  })
    println(salarios.any { it == 1000.00  })




}