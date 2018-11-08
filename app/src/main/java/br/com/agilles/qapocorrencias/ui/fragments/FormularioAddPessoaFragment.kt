package br.com.agilles.qapocorrencias.ui.fragments

import android.app.DatePickerDialog
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.agilles.qapocorrencias.R
import br.com.agilles.qapocorrencias.database.Database
import br.com.agilles.qapocorrencias.database.PessoaDao
import br.com.agilles.qapocorrencias.delegate.PessoasDelegate
import br.com.agilles.qapocorrencias.extension.formataParaBrasileiro
import br.com.agilles.qapocorrencias.model.Pessoa
import kotlinx.android.synthetic.main.fragment_formulario_add_pessoa.*
import java.util.*

class FormularioAddPessoaFragment : Fragment() {

    private val delegate by lazy {
        activity as PessoasDelegate
    }
    private lateinit var pessoaDao: PessoaDao

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_formulario_add_pessoa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            val database = Database.instance(it)
            pessoaDao = database.pessoaDao()

        }
        configuraCampoData()
        form_add_pessoa_botao_salvar.setOnClickListener {
            if (validaCampos()) {
                recuperaCampos()
            }

        }
        configuraBotaoSalvar()

    }

    private fun configuraBotaoSalvar() {
        form_add_pessoa_botao_salvar.setOnClickListener {
            salvarPessoa()
        }

    }

    private fun salvarPessoa() {
        SalvaPessoa().execute()

    }

    inner class SalvaPessoa : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg p0: Void?): Void? {
            val pessoaCriada = criar()
            pessoaDao.insere(pessoaCriada)
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            delegate.voltaParaTelaAnterior()
        }

    }

    private fun criar():Pessoa {
        val nome = form_add_pessoa_edit_nome.text.toString()
        val apelido = form_add_pessoa_edit_apelido.text.toString()
        val nascimento = form_add_pessoa_edit_nascimento.text.toString()
        val telefone = form_add_pessoa_edit_telefone.text.toString()
        return Pessoa(nome = nome, apelido = apelido, nascimento = nascimento, telefone = telefone)


    }

    private fun validaCampos(): Boolean {
        limpaErros()
        if (form_add_pessoa_edit_nome.text.toString().isEmpty()) {
            form_add_pessoa_nome_text_input.error = "Nome deve ser preenchido"
            return false
        } else if (form_add_pessoa_edit_apelido.text.toString().isEmpty()) {
            form_add_pessoa_apelido_text_input.error = "Preencha um apelido"
            return false
        } else if (form_add_pessoa_edit_nascimento.text.toString().isEmpty()) {
            form_add_pessoa_nascimento_text_input.error = "Selecione uma data de nascimento"
            return false
        } else if (form_add_pessoa_edit_telefone.text.toString().isEmpty()) {
            form_add_pessoa_telefone_text_input.error = "Preencha um número de telefone"
            return false
        } else {
            return true
        }

    }

    private fun limpaErros() {
        form_add_pessoa_apelido_text_input.error = null
        form_add_pessoa_nascimento_text_input.error = null
        form_add_pessoa_nome_text_input.error = null
        form_add_pessoa_telefone_text_input.error = null

    }


    private fun recuperaCampos() {
        val nome = form_add_pessoa_edit_nome.text.toString()
        val nascimento = form_add_pessoa_edit_nascimento.text.toString()
        val apelido = form_add_pessoa_edit_apelido.text.toString()
        val telefone = form_add_pessoa_edit_telefone.text.toString()
        val pessoa = Pessoa(nome = nome, nascimento = nascimento, apelido = apelido, telefone = telefone)
    }


    private fun configuraCampoData() {
        val hoje = Calendar.getInstance()
        val ano = hoje.get(Calendar.YEAR)
        val mes = hoje.get(Calendar.MONTH)
        val dia = hoje.get(Calendar.DAY_OF_MONTH)


        form_add_pessoa_edit_nascimento.setOnClickListener {
            DatePickerDialog(context,
                    { _, ano, mes, dia ->
                        val dataSelecionada = Calendar.getInstance()
                        dataSelecionada.set(ano, mes, dia)
                        form_add_pessoa_edit_nascimento.setText(dataSelecionada.formataParaBrasileiro())
                    }
                    , ano, mes, dia)
                    .show()
        }

    }


    override fun onResume() {
        super.onResume()
        delegate.alteraTitulo("Adicionar pessoa")

    }


}