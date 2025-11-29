package com.example.petagram;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.network.ApiService;
import com.example.petagram.network.PostResponse;
import com.example.petagram.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TimelineActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private List<PostResponse> postList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        recyclerView = findViewById(R.id.recyclerViewPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PostAdapter(postList);
        recyclerView.setAdapter(adapter);

        cargarPosts();
    }

    private void cargarPosts() {
        Retrofit retrofit = RetrofitClient.INSTANCE.getInstance();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<PostResponse>> call = apiService.getPosts();

        call.enqueue(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    postList.clear();
                    postList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    Toast.makeText(TimelineActivity.this, "✅ Datos cargados correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TimelineActivity.this, "⚠️ Error al cargar datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {
                Toast.makeText(TimelineActivity.this, "❌ Fallo: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
