package br.com.agilles.qapocorrencias.database

import android.arch.persistence.room.*
import br.com.agilles.qapocorrencias.model.Endereco
import br.com.agilles.qapocorrencias.model.Pessoa

@Dao
interface EnderecoDao {

    @Insert
    fun insere(endereco: Endereco)

    @Query("SELECT * FROM endereco")
    fun todos(): List<Endereco>

    @Query("Select * from endereco Where logradouro like :logradouro")
    fun enderecoPorRua(logradouro: String): Endereco

    @Update
    fun alterar(endereco: Endereco)

    @Delete
    fun deletar(endereco: Endereco)


}