package br.com.agilles.qapocorrencias.database

import android.arch.persistence.room.*
import br.com.agilles.qapocorrencias.model.Endereco
import br.com.agilles.qapocorrencias.model.Ocorrencia
import br.com.agilles.qapocorrencias.model.Pessoa

@Dao
interface OcorrenciaDao {

    @Insert
    fun insere(ocorrencia: Ocorrencia)

    @Query("SELECT * FROM ocorrencia")
    fun todos(): List<Ocorrencia>

    @Update
    fun alterar(ocorrencia: Ocorrencia)

    @Delete
    fun deletar(ocorrencia: Ocorrencia)


}