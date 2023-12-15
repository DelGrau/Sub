package com.example.sub.controller;

import android.content.Context;
import android.util.Log;

import com.example.sub.dao.PaisDao;
import com.example.sub.dto.PaisDTO;
import com.example.sub.model.Pais;
import com.example.sub.retrofit.RetrofitConfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaisController {

    private Context context;

    public PaisController(Context context) {
        this.context = context;
    }

    public static void salvarPais(String codigo, String descricao, Context context) {
        try {
            Pais pais = PaisDao.getInstancia(context).getById(Integer.parseInt(codigo));
            if (pais!=null){
                // return "o código " + codigo + " já está cadastrado!";
            } else {
                pais = new Pais();
                pais.setId(Integer.parseInt(codigo));
                pais.setDescricao(descricao);

                PaisDao.getInstancia(context).insert(pais);
            }

        } catch (Exception ex) {
            Log.e("ERRO", "ERRO: PaisController.salvarPais() " + ex.getMessage());
        }
    }

    public static ArrayList<Pais> retornarTodosPaises(Context context) {
        return PaisDao.getInstancia(context).getAll();
    }

    public static void getPaises(Context context) {
        try {
            Call<ArrayList<PaisDTO>> call = new RetrofitConfig()
                    .paisService().getPaises();

            call.enqueue(new Callback<ArrayList<PaisDTO>>() {
                @Override
                public void onResponse(Call<ArrayList<PaisDTO>> call, Response<ArrayList<PaisDTO>> response) {
                    ArrayList<PaisDTO> lista = response.body();
                    for (int i = 0; i < lista.size(); i++) {
                        PaisDTO p = lista.get(i);

                        salvarPais(p.getCodigo(), p.getDescricao(), context);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<PaisDTO>> call, Throwable t) {

                }
            });
        } catch (Exception ex) {}
    }
}
