package com.example.moneda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import android.view.View
class MainActivity : AppCompatActivity() {

    private lateinit var editTextCantidad: EditText
    private lateinit var radioDolares: RadioButton
    private lateinit var radioSoles: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCantidad = findViewById(R.id.editTextText)
        radioDolares = findViewById(R.id.radio0)
        radioSoles = findViewById(R.id.radio1)
    }

    private fun convertirMoneda() {
        val texto = editTextCantidad.text.toString()

        if (texto.isEmpty()) {
            Toast.makeText(this, "Ingresa cantidad", Toast.LENGTH_SHORT).show()
            return
        }

        val cantidad = texto.toFloat()
        val tipoCambio = 3.65f

        if (radioDolares.isChecked) {
            val soles = cantidad * tipoCambio
            Toast.makeText(this, "$cantidad dólares = $soles soles", Toast.LENGTH_LONG).show()
        } else {
            val dolares = cantidad / tipoCambio
            Toast.makeText(this, "$cantidad soles = $dolares dólares", Toast.LENGTH_LONG).show()
        }
    }

    fun miClicManejador(view: View) {
        if (view.id == R.id.btnConvertir) {
            convertirMoneda()
        }
    }
}