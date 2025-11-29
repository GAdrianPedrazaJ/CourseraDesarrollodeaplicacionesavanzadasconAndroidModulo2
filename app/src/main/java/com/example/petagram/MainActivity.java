package com.example.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.petagram.network.ApiService;
import com.example.petagram.network.RetrofitClient;
import com.example.petagram.network.PostResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnConfigurarCuenta = findViewById(R.id.btnConfigurarCuenta);

        btnConfigurarCuenta.setOnClickListener(v -> {
            conectarConApi();
            Intent intent = new Intent(MainActivity.this, ConfigurarCuentaActivity.class);
            startActivity(intent);
        });
    }

    private void conectarConApi() {
        Retrofit retrofit = RetrofitClient.INSTANCE.getInstance();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<PostResponse> call = apiService.getPost(); // Usamos endpoint de prueba

        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String title = response.body().getTitle();
                    Toast.makeText(MainActivity.this,
                            "✅ Conexión OK: " + title,
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "⚠️ Error: " + response.code(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "❌ Falló la conexión: " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}