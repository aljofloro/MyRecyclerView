package com.miempresa.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private List<Persona> personas;

  private void inicializarDatos(){
    personas = new ArrayList<>();
    personas.add(new Persona("Ada Lovelace","25 años de edad"
        ,R.drawable.lovelace));
    personas.add(new Persona("Marie Curie","35 años de edad"
        ,R.drawable.curie));
    personas.add(new Persona("Ruth Wakefield","29 años de edad"
        ,R.drawable.wakefield));
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
    recyclerView.setHasFixedSize(true);

    LinearLayoutManager linearLayoutManager =
        new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(linearLayoutManager);

    inicializarDatos();

    RVAdapter rvAdapter = new RVAdapter(personas,getApplicationContext());
    recyclerView.setAdapter(rvAdapter);
  }
}