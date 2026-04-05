package com.mh.gestaopedidos

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os componentes da UI
        val chkCafe = findViewById<CheckBox>(R.id.chkCafe)
        val edtCafe = findViewById<EditText>(R.id.edtQtdCafe)
        val txtSubCafe = findViewById<TextView>(R.id.txtSubCafe) // NOVO

        val chkPao = findViewById<CheckBox>(R.id.chkPao)
        val edtPao = findViewById<EditText>(R.id.edtQtdPao)
        val txtSubPao = findViewById<TextView>(R.id.txtSubPao) // NOVO

        val chkChoc = findViewById<CheckBox>(R.id.chkChoc)
        val edtChoc = findViewById<EditText>(R.id.edtQtdChoc)
        val txtSubChoc = findViewById<TextView>(R.id.txtSubChoc) // NOVO

        val btnPedir = findViewById<Button>(R.id.btnPedir)

        // Preços fixos definidos na regra de negócio
        val precoCafe = 1.0
        val precoPao = 0.5
        val precoChoc = 1.2

        // Função auxiliar para calcular e atualizar o subtotal visível de um item
        fun atualizarSubtotalItem(edit: EditText, textViewSubtotal: TextView, precoUnitario: Double, isChecked: Boolean) {
            if (!isChecked) {
                textViewSubtotal.text = "0.00€"
                return
            }

            val quantidadeText = edit.text.toString()
            val quantidade = if (quantidadeText.isEmpty()) 0 else quantidadeText.toIntOrNull() ?: 1
            val subtotal = quantidade * precoUnitario
            textViewSubtotal.text = "${String.format("%.2f", subtotal)}€"
        }

        // Função auxiliar para configurar o comportamento dinâmico
        fun configurarComportamentoDinamico(check: CheckBox, edit: EditText, textViewSubtotal: TextView, precoUnitario: Double) {
            // Regra: Ativar CheckBox = Ativar EditText e Quantidade 1
            check.setOnCheckedChangeListener { _, isChecked ->
                edit.isEnabled = isChecked
                if (isChecked) {
                    edit.setText("1") // Regra de negócio cumprida aqui
                    atualizarSubtotalItem(edit, textViewSubtotal, precoUnitario, true)
                } else {
                    edit.setText("")
                    atualizarSubtotalItem(edit, textViewSubtotal, precoUnitario, false)
                }
            }

            // Regra: Permitir alteração manual da quantidade e atualizar o subtotal instantaneamente
            edit.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    // Atualiza o subtotal visível sempre que a quantidade muda
                    atualizarSubtotalItem(edit, textViewSubtotal, precoUnitario, check.isChecked)
                }
            } )
        }

        // Aplicar o comportamento dinâmico aos 3 produtos
        configurarComportamentoDinamico(chkCafe, edtCafe, txtSubCafe, precoCafe)
        configurarComportamentoDinamico(chkPao, edtPao, txtSubPao, precoPao)
        configurarComportamentoDinamico(chkChoc, edtChoc, txtSubChoc, precoChoc)

        // Lógica do Clique no Botão (calcula tudo para o resumo final)
        btnPedir.setOnClickListener {
            val resumo = StringBuilder()
            var totalGeral = 0.0

            if (chkCafe.isChecked) {
                val qtd = edtCafe.text.toString().toIntOrNull() ?: 1
                val subtotal = qtd * precoCafe
                resumo.append("Café: $qtd x ${String.format("%.2f", precoCafe)}€ = ${String.format("%.2f", subtotal)}€\n")
                totalGeral += subtotal
            }

            if (chkPao.isChecked) {
                val qtd = edtPao.text.toString().toIntOrNull() ?: 1
                val subtotal = qtd * precoPao
                resumo.append("Pão: $qtd x ${String.format("%.2f", precoPao)}€ = ${String.format("%.2f", subtotal)}€\n")
                totalGeral += subtotal
            }

            if (chkChoc.isChecked) {
                val qtd = edtChoc.text.toString().toIntOrNull() ?: 1
                val subtotal = qtd * precoChoc
                resumo.append("Chocolate: $qtd x ${String.format("%.2f", precoChoc)}€ = ${String.format("%.2f", subtotal)}€\n")
                totalGeral += subtotal
            }

            if (totalGeral == 0.0) {
                Toast.makeText(this, "Selecione pelo menos um item!", Toast.LENGTH_SHORT).show()
            } else {
                resumo.append("\nTOTAL A PAGAR: ${String.format("%.2f", totalGeral)}€")

                val intent = Intent(this, PrepareActivity::class.java)
                intent.putExtra("RESUMO", resumo.toString())
                startActivity(intent)
            }
        }
    }
}