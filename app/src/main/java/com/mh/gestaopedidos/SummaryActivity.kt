package com.mh.gestaopedidos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val txtFinal = findViewById<TextView>(R.id.txtFinal)
        val btnNovo = findViewById<Button>(R.id.btnNovo)

        // IMPORTANTE: A chave tem de ser "RESUMO" para coincidir com os outros ecrãs
        val resumoFinal = intent.getStringExtra("RESUMO")

        if (resumoFinal != null) {
            txtFinal.text = resumoFinal
        } else {
            txtFinal.text = "Erro: Não foi possível receber os dados do pedido."
        }

        btnNovo.setOnClickListener {
            finish()
        }
    }
}