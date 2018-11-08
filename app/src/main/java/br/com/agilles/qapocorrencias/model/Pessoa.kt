package br.com.agilles.qapocorrencias.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.Calendar

@Entity
class Pessoa(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val nome: String,
        val apelido: String,
        val nascimento: String,
        val telefone: String)
