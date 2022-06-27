package one.digitalinnovation.digionebank

import java.math.BigDecimal

abstract class Funcionario (
    override val nome: String,
    override val cpf: String,
    val salario: Double,
) : Pessoa (nome,cpf) {
    protected abstract fun calculoAuxilio(): Double

    override fun toString(): String= """
        Nome: $nome
        Cpf: $cpf
        Salario: $salario
        Auxilio: ${calculoAuxilio()}
       """.trimIndent()
}