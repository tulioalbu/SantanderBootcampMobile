package one.digitalinnovation.collections

data class funcionario (
    val nome: String,
    val salario: Double,
    val tipoContratacao: String
) {

    override fun toString(): String =
        """
            Nome: $nome
            Salário: $salario
            Tipo do Contrato: $tipoContratacao
        """.trimIndent()

}
