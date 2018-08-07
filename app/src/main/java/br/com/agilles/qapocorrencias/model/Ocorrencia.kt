package br.com.agilles.qapocorrencias.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.Calendar

@Entity
class Ocorrencia(@PrimaryKey(autoGenerate = true)
                 val id: Long,
                 val pessoa: Pessoa,
                 val dataOcorrencia: Calendar,
                 val natureza: String,
                 val resumo: String,
                 val numeroControle: String,
                 val fotoCapa: String,
                 val endereco: Endereco)