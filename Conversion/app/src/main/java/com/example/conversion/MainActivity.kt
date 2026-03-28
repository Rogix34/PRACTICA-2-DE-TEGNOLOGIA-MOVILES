package com.example.conversion

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var txtMonto: EditText
    lateinit var spOrigen: Spinner
    lateinit var spDestino: Spinner
    lateinit var btnConvertir: Button
    lateinit var txtResultado: TextView

    val monedas = arrayOf("USD", "PEN", "EUR", "GBP", "INR", "BRL", "MXN", "CNY", "JPY")

    val tasas = mapOf(
        "USD" to 1.0,
        "PEN" to 3.75,
        "EUR" to 0.92,
        "GBP" to 0.78,
        "INR" to 83.0,
        "BRL" to 5.0,
        "MXN" to 17.0,
        "CNY" to 7.2,
        "JPY" to 150.0
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtMonto = findViewById(R.id.txtMonto)
        spOrigen = findViewById(R.id.spOrigen)
        spDestino = findViewById(R.id.spDestino)
        btnConvertir = findViewById(R.id.btnConvertir)
        txtResultado = findViewById(R.id.txtResultado)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monedas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spOrigen.adapter = adapter
        spDestino.adapter = adapter

        btnConvertir.setOnClickListener {

            val texto = txtMonto.text.toString()

            if (texto.isEmpty()) {
                Toast.makeText(this, "Ingrese un monto", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val monto = texto.toDouble()
            val origen = spOrigen.selectedItem.toString()
            val destino = spDestino.selectedItem.toString()

            val resultado = convertir(monto, origen, destino)

            txtResultado.text = "Resultado: $resultado"
        }
    }

    fun convertir(monto: Double, origen: String, destino: String): Double {
        val enDolares = monto / tasas[origen]!!
        return enDolares * tasas[destino]!!
    }
}