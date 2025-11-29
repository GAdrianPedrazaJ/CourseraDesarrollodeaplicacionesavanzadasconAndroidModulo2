package com.example.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConfigurarCuentaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        Button btnVolverInicio = findViewById(R.id.btnVolverInicio);

        btnVolverInicio.setOnClickListener(v -> {
            // Regresa al MainActivity. startActivity + finish evita duplicados en la pila.
            Intent intent = new Intent(ConfigurarCuentaActivity.this, TimelineActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
