package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtMonto;
    Button btnConvertir;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMonto = findViewById(R.id.txtMonto);
        btnConvertir = findViewById(R.id.btnConvertir);
        txtResultado = findViewById(R.id.txtResultado);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = txtMonto.getText().toString();

                if (texto.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Ingrese un monto", Toast.LENGTH_SHORT).show();
                    return;
                }

                double monto = Double.parseDouble(texto);
                double resultado = monto * 3.75; // USD a PEN

                txtResultado.setText("Resultado: " + resultado);
            }
        });
    }
}