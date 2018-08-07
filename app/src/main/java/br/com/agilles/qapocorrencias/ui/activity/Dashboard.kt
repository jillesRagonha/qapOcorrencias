package br.com.agilles.qapocorrencias.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.agilles.qapocorrencias.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        title = "Dashboard"
        dashboard_pessoas.setOnClickListener {
            val intent = Intent(this@Dashboard, PessoasActivity::class.java)
            startActivity(intent)
        }

    }



}
