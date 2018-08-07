package br.com.agilles.qapocorrencias.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.agilles.qapocorrencias.R
import br.com.agilles.qapocorrencias.delegate.PessoasDelegate
import br.com.agilles.qapocorrencias.model.Pessoa
import br.com.agilles.qapocorrencias.ui.adapter.PessoasAdapter
import kotlinx.android.synthetic.main.fragment_lista_pessoas.*

class ListaPessoasFragment : Fragment() {

    private val delegate by lazy {
        activity as PessoasDelegate
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista_pessoas, container, false)
        // Se eu chamar o configuraView aqui, ele da erro de recycler view null
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Para evitar esse erro, estou chamando aqui
        configuraComponentesDaView(view)
    }

    private fun configuraComponentesDaView(view: View?) {
        configuraView(view)

    }

    private fun configuraView(view: View?) {
        val recyclerView = fragment_lista_pessoas_recycler_view
        with(recyclerView) {
            context?.let {
                adapter = PessoasAdapter(listaPessoas(), it)
            }
        }
    }

    private fun listaPessoas(): List<Pessoa> {

        return listOf(
                Pessoa(nome = "Jilles Ragonha"),
                Pessoa(nome = "Jefferson Ragonha"),
                Pessoa(nome = "Jean Ragonha"))


    }

    override fun onResume() {
        super.onResume()
        delegate.alteraTitulo("Lista de Pessoas")

    }


}
