package com.example.primeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {
    private ArrayList<Alumno> listadoAlumnos;
    private ListView lstListado;
    private ArrayAdapter<Alumno> adaptadorListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lstListado = findViewById(R.id.lstListado);


        String nombre = getIntent().getExtras().getString("nombre", "sin nombre");
        int edad = getIntent().getExtras().getInt("edad", 0);
        listadoAlumnos = (ArrayList) getIntent().getExtras().getSerializable("listado");

        /*for(Alumno alumno : listadoAlumnos){
            Log.d("TAG_", "Nombre " + alumno.getNombre());
        }*/

        adaptadorListado = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listadoAlumnos);
        lstListado.setAdapter(adaptadorListado);

    }
}