package com.example.sub.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sub.R;
import com.example.sub.controller.PaisController;

public class MainActivity extends AppCompatActivity {

    TextView tvSituacao;
    Button btMostrarDados;
    Button btCarregarPaises;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMostrarDados = findViewById(R.id.btMostrarDados);
        btCarregarPaises = findViewById(R.id.btCarregarPaises);
        tvSituacao = findViewById(R.id.tvSituacao);

        tvSituacao.setText("Clique em Carregar Países para conectar com a Api...");

        // Método para solicitar os dados para a API
        btCarregarPaises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSituacao.setText("Solicitando dados da Api...\n");

                if(PaisController.getPaises(MainActivity.this)) {
                    tvSituacao.setText(tvSituacao.getText()+"Dados da API: Ok\n");
                } else {
                    tvSituacao.setText(tvSituacao.getText()+"Houve um erro ao receber os dados da Api\n");
                }
            }
        });

        // Método para mostrar os dados depois de solicitar para a API
        btMostrarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                abrirView();

            }
        });
    }

    private void abrirView() {
        Intent intent = new Intent(MainActivity.this,
                PaisesActivity.class);
        startActivity(intent);
    }
}