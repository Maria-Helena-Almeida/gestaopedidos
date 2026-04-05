package com.mh.gestaopedidos

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class PrepareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prepare)

        // 1. Recuperar o resumo que veio da MainActivity usando a chave "RESUMO"
        val resumoVindoDaMain = intent.getStringExtra("RESUMO") 

        // 2. Esperar 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            
            // 3. Criar a intenção para a SummaryActivity
            val intentDestino = Intent(this, SummaryActivity::class.java)
            
            // 4. Passar os dados usando a MESMA chave "RESUMO"
            intentDestino.putExtra("RESUMO", resumoVindoDaMain)
            
            startActivity(intentDestino)
            
            // 5. Fechar esta activity
            finish()
            
        }, 3000)
    }
}