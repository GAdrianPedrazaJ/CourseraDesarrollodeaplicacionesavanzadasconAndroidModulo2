package com.example.petagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FotoAdapter extends RecyclerView.Adapter<FotoAdapter.FotoViewHolder> {

    private List<Foto> listaFotos;

    public FotoAdapter(List<Foto> listaFotos) {
        this.listaFotos = listaFotos;
    }

    @NonNull
    @Override
    public FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_foto, parent, false);
        return new FotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FotoViewHolder holder, int position) {
        Foto foto = listaFotos.get(position);
        holder.tvDescripcion.setText(foto.getDescripcion());
        Picasso.get().load(foto.getUrl()).into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        return listaFotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvDescripcion;

        public FotoViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivFoto);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
        }
    }
}

