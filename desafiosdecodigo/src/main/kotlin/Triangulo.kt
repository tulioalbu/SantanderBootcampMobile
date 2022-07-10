// Desafio
//Leia 3 valores reais (A, B e C) e verifique se eles formam ou não um triângulo. Em caso positivo,
// calcule o perímetro do triângulo (soma de todos os lados) e apresente a mensagem:
//
//Perimetro = XX.X
//
//Em caso negativo, calcule a área do trapézio que tem A e B como base e C como altura, mostrando a mensagem:
//
//Area = XX.X
//
//Fórmula da área de um trapézio: AREA = ((A + B) x C) / 2
//
//Entrada
//A entrada contém três valores reais.
//
//Saída
//O resultado deve ser apresentado com uma casa decimal.

fun main() {
    val input = readLine()!!
    val a = input.split(" ")[0].toFloat()
    val b = input.split(" ")[1].toFloat()
    val c = input.split(" ")[2].toFloat()

    val perimetro = a + b + c
    val area = ((a+b)*c)/2

    if (a<(b + c) &&  b<(a + c) && c<(a + b)){
        println(String.format("Perimetro = %.1f", perimetro))
    }else{
        println(String.format("Area = %.1f", area ))
    }

}