package br.com.agilles.qapocorrencias.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Endereco(@PrimaryKey(autoGenerate = true)
               val id: Long,
               val logradouro: String,
               val bairro: String,
               val cidade: String,
               val numero: Int)