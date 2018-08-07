package br.com.agilles.qapocorrencias.delegate

import br.com.agilles.qapocorrencias.model.Pessoa

interface PessoasDelegate {

    fun lidaComCliqueFAB()

    fun alteraTitulo(nome: String)

    fun voltaParaTelaAnterior()

    fun lidaComPessoaSelecionada(pessoa: Pessoa)


}