package com.example.calculadoragorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextBillAmount = findViewById<EditText>(R.id.editTextBillAmount)
        val editTextTipPercentage = findViewById<EditText>(R.id.editTextTipPercentage)
        val buttonCalculateTip = findViewById<Button>(R.id.buttonCalculateTip)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculateTip.setOnClickListener {
            val billAmount = editTextBillAmount.text.toString().toFloatOrNull()
            val tipPercentage = editTextTipPercentage.text.toString().toFloatOrNull()

            if (billAmount != null && tipPercentage != null) {
                val tip = billAmount * (tipPercentage / 100)
                val total = billAmount + tip

                textViewResult.text = "Gorjeta: R$ %.2f\nTotal: R$ %.2f".format(tip, total)
            } else {
                textViewResult.text = "Por favor, insira valores válidos."
            }
        }
    }
}