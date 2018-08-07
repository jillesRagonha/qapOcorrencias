package br.com.agilles.qapocorrencias.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import br.com.agilles.qapocorrencias.R
import br.com.agilles.qapocorrencias.delegate.PessoasDelegate
import br.com.agilles.qapocorrencias.model.Pessoa
import br.com.agilles.qapocorrencias.ui.fragments.ListaPessoasFragment

class PessoasActivity : AppCompatActivity(), PessoasDelegate {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pessoas)
        exibeFragment(ListaPessoasFragment(), false)
    }

    private fun exibeFragment(fragment: Fragment, empilhado: Boolean) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        with(transaction) {
            replace(R.id.pessoas_frame_layout, fragment)
            if (empilhado) {
                addToBackStack(null)
            }
            commit()
        }


    }

    override fun lidaComCliqueFAB() {

    }

    override fun alteraTitulo(nome: String) {
        title = nome
    }

    override fun voltaParaTelaAnterior() {
        onBackPressed()

    }

    override fun lidaComPessoaSelecionada(pessoa: Pessoa) {


    }


}
