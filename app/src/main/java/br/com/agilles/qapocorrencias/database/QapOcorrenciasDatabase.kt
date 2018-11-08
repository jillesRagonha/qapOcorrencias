package br.com.agilles.qapocorrencias.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import br.com.agilles.qapocorrencias.model.Endereco
import br.com.agilles.qapocorrencias.model.Ocorrencia
import br.com.agilles.qapocorrencias.model.Pessoa

@Database(entities = [Pessoa::class], version = 1)
abstract class QapOcorrenciasDatabase : RoomDatabase() {

    abstract fun pessoaDao(): PessoaDao


}

object Database {
    @Volatile
    private lateinit var database: QapOcorrenciasDatabase

    fun instance(context: Context): QapOcorrenciasDatabase {
        synchronized(this) {
            if (::database.isInitialized) return database
            database = Room.databaseBuilder(context, QapOcorrenciasDatabase::class.java,
                    "qapDatabase")
                    .build()
            return database
        }
    }
}