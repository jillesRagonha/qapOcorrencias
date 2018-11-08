package br.com.agilles.qapocorrencias.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import br.com.agilles.qapocorrencias.model.Pessoa

@Dao
interface PessoaDao {

    @Insert
    fun insere(pessoa: Pessoa)

    @Query("SELECT * FROM pessoa")
    fun todas(): LiveData<List<Pessoa>>

    @Query("Select * from pessoa Where nome like :nome")
    fun pessoaPorNome(nome: String): Pessoa

    @Query("Select * from pessoa Where apelido like :apelido")
    fun pessoaPorApelido(apelido: String): Pessoa

    @Update
    fun alterar(pessoa: Pessoa)

    @Delete
    fun deletar(pessoa: Pessoa)


}