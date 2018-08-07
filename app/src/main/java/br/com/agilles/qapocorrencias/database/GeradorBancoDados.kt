package br.com.agilles.qapocorrencias.database

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

class GeradorBancoDados {

    fun gera(context: Context): QapOcorrenciasDatabase {
        return Room.databaseBuilder(context, QapOcorrenciasDatabase::class.java, "QapOcorrenciasDB").build()
    }
}