package com.example.pizzas

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var gridView: GridView

    val nombres = arrayOf(
        "Pepperoni",
        "Hawaiana",
        "Vegetariana",
        "Cuatro Quesos"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridView)

        val adapter = PizzaAdapter(this)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, nombres[position], Toast.LENGTH_SHORT).show()
        }
    }
}