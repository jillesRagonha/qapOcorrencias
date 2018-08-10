package br.com.agilles.qapocorrencias.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.agilles.qapocorrencias.R
import br.com.agilles.qapocorrencias.delegate.PessoasDelegate
import kotlinx.android.synthetic.main.fragment_formulario_add_pessoa.*

class FormularioAddPessoaFragment : Fragment() {

    private val delegate by lazy {
        activity as PessoasDelegate
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_formulario_add_pessoa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



    override fun onResume() {
        super.onResume()
        delegate.alteraTitulo("Adicionar pessoa")

    }




}