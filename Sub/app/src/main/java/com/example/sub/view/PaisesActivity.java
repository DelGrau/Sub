package com.example.sub.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.sub.R;
import com.example.sub.adapter.AdapterPais;
import com.example.sub.controller.PaisController;
import com.example.sub.model.Pais;

import java.util.ArrayList;

public class PaisesActivity extends AppCompatActivity {

    private PaisController controller;
    private RecyclerView rvPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);

        rvPais = findViewById(R.id.rvPais);
        carregarPaises();
    }

    private void carregarPaises() {
        ArrayList<Pais> listaPaises = PaisController.retornarTodosPaises(this);
        AdapterPais adapter = new AdapterPais(this, listaPaises);

        rvPais.setLayoutManager(new LinearLayoutManager(this));
        rvPais.setAdapter(adapter);
    }
}