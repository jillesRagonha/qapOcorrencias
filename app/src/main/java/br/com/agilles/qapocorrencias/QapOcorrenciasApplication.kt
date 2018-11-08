package br.com.agilles.qapocorrencias

import android.app.Application
import br.com.agilles.qapocorrencias.di.koin.modules.dbModule
import br.com.agilles.qapocorrencias.di.koin.modules.uiModule
import org.koin.android.ext.android.startKoin

class QapOcorrenciasApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(uiModule, dbModule))
    }
}