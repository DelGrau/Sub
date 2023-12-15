package com.example.sub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sub.R;
import com.example.sub.model.Pais;

import java.util.ArrayList;

public class AdapterPais extends RecyclerView.Adapter<AdapterPais.ViewHolder> {

    private Context context;
    private ArrayList<Pais> listaPaises;
    private LayoutInflater inflater;

    public AdapterPais(Context context, ArrayList<Pais> listaPaises) {
        this.context = context;
        this.listaPaises = listaPaises;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_pais, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pais pais = listaPaises.get(position);
        holder.tvCodigo.setText(String.valueOf(pais.getId()));
        holder.tvDescricao.setText(pais.getDescricao());
    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCodigo;
        private TextView tvDescricao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvCodigo = itemView.findViewById(R.id.tvCodigo);
            this.tvDescricao = itemView.findViewById(R.id.tvDescricao);
        }
    }
}
