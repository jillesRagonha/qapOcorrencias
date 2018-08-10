package br.com.agilles.qapocorrencias.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import br.com.agilles.qapocorrencias.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        title = "Dashboard"
        dashboard_pessoas.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                vaiParaPessoasActivityComAnimacao()
            } else {
                vaiParaPessoasActivitySemAnimacao()
            }

        }

    }

    private fun vaiParaPessoasActivitySemAnimacao() {
        val intent = Intent(this, PessoasActivity::class.java)
        startActivity(intent)
    }

    fun vaiParaPessoasActivityComAnimacao() {
        val intent = Intent(this, PessoasActivity::class.java)
        startActivity(intent)
    }


}
