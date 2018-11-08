package br.com.agilles.qapocorrencias.ui.fragments

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.agilles.qapocorrencias.R
import br.com.agilles.qapocorrencias.database.PessoaDao
import br.com.agilles.qapocorrencias.delegate.PessoasDelegate
import br.com.agilles.qapocorrencias.ui.adapter.PessoasAdapter
import kotlinx.android.synthetic.main.fragment_lista_pessoas.*
import org.koin.android.ext.android.inject

class ListaPessoasFragment : Fragment() {

    private val delegate by lazy {
        activity as PessoasDelegate
    }
    private val pessoaDao: PessoaDao by inject()
    private val adapter: PessoasAdapter by inject()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_pessoas, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pessoas = pessoaDao.todas()
        pessoas.observe(this, Observer { pessoas ->
            pessoas?.let {
                adapter.trocarTodasPessoas(it)
            }
        })
        configuraComponentesDaView(view)
    }

    private fun configuraComponentesDaView(view: View?) {
        configuraView(view)
        configuraFab(view)

    }

    private fun configuraFab(view: View?) {
        fab_add_pessoa.setOnClickListener {
            delegate.lidaComCliqueFAB()
        }
    }

    private fun configuraView(view: View?) {
        val recyclerView = fragment_lista_pessoas_recycler_view
        recyclerView.adapter = adapter

    }


    override fun onResume() {
        super.onResume()
        delegate.alteraTitulo("Lista de Pessoas")

    }


}
