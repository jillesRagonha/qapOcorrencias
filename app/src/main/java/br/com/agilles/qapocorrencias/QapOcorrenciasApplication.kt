package br.com.agilles.qapocorrencias

import android.app.Application
import android.content.Context
import br.com.agilles.qapocorrencias.di.koin.modules.dbModule
import br.com.agilles.qapocorrencias.di.koin.modules.uiModule
import org.koin.android.ext.android.startKoin
import org.koin.core.KoinContext

class QapOcorrenciasApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(uiModule, dbModule))
    }
}