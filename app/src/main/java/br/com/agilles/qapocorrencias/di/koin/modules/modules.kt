package br.com.agilles.qapocorrencias.di.koin.modules

import android.arch.persistence.room.Room
import br.com.agilles.qapocorrencias.database.QapOcorrenciasDatabase
import br.com.agilles.qapocorrencias.ui.adapter.PessoasAdapter
import org.koin.dsl.module.module

val dbModule = module {
    single {
        Room.databaseBuilder(get(),
                QapOcorrenciasDatabase::class.java,
                "qapDatabase")
                .build()
    }

    single {
        get<QapOcorrenciasDatabase>().pessoaDao()
    }

}

val uiModule = module {
    factory {
        PessoasAdapter(context = get())
    }
}