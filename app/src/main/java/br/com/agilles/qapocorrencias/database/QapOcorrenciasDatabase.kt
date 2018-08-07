package br.com.agilles.qapocorrencias.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import br.com.agilles.qapocorrencias.model.Endereco
import br.com.agilles.qapocorrencias.model.Ocorrencia
import br.com.agilles.qapocorrencias.model.Pessoa

@Database(entities = [Pessoa::class, Endereco::class, Ocorrencia::class], version = 1)
abstract class QapOcorrenciasDatabase : RoomDatabase() {

    abstract fun pessoaDao():PessoaDao

    abstract fun enderecoDao():EnderecoDao

    abstract fun ocorrenciaDao():OcorrenciaDao


}