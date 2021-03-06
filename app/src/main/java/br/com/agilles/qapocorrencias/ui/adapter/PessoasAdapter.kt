package br.com.agilles.qapocorrencias.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.agilles.qapocorrencias.R
import br.com.agilles.qapocorrencias.model.Pessoa
import kotlinx.android.synthetic.main.item_pessoa.view.*

class PessoasAdapter(private val pessoas: MutableList<Pessoa> = mutableListOf(),
                     private val context: Context) : RecyclerView.Adapter<PessoasAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_pessoa, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return pessoas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pessoa = pessoas[position]
        holder.bindView(pessoa)

    }

    fun trocarTodasPessoas(pessoas: List<Pessoa>) {
        this.pessoas.clear()
        this.pessoas.addAll(pessoas)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(pessoa: Pessoa) {
            itemView.item_pessoa_nome.text = pessoa.nome
            itemView.item_pessoa_apelido.text = pessoa.apelido
            itemView.item_pessoa_nascimento.text = pessoa.nascimento

        }
    }

}