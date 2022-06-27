package one.digitalinnovation.digionebank.testes


import one.digitalinnovation.digionebank.Analista

fun main() {
    val tulio = Analista("Túlio Albuquerque", "1234567899", 3500.0)

    ImprimeRelatorioFuncionario.imprime(tulio)
}