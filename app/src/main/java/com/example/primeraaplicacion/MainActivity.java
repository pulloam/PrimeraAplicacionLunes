package com.example.primeraaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView tvTit;
    private EditText etMatricula,etNombre, etCorreo, etCarrera;
    private Button btnAce,btnSal, btnAvanzar, btnRetroceder, btnListar;

    private ArrayList<Alumno> losAlumnos = new ArrayList<>();

    private int indice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referencias();
        eventos();
    }

    @Override
    protected void onResume() {
        super.onResume();

        limpiarPantalla();
        indice = 0;
    }

    private void referencias(){
        tvTit = findViewById(R.id.tvTitulo);
        etMatricula = findViewById(R.id.etMatricula);
        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etCarrera = findViewById(R.id.etCarrera);
        btnAce = findViewById(R.id.btnAceptar);
        btnSal = findViewById(R.id.btnSalir);
        btnAvanzar = findViewById(R.id.btnAvanzar);
        btnRetroceder = findViewById(R.id.btnRetroceder);
        btnListar = findViewById(R.id.btnListar);
    }

    private Boolean validarDatos(){
        String matricula;
        int matriculaInt;
        String nombre, correo, carrera;
        boolean vOK = true;

        matricula = etMatricula.getText().toString();
        nombre = etNombre.getText().toString();
        correo = etCorreo.getText().toString();
        carrera = etCarrera.getText().toString();

        if(matricula.isEmpty()){
            etMatricula.setError("Dato obligatorio");
            vOK = false;
        }

        if(nombre.isEmpty()){
            etNombre.setError("Dato obligatorio");
            vOK = false;
        }

        if(correo.isEmpty()){
            etCorreo.setError("Dato obligatorio");
            vOK = false;
        }

        if(carrera.isEmpty()){
            etCarrera.setError("Dato obligatorio");
            vOK = false;
        }

        return vOK;
    }

    private void listarAlumnos(){
        //Alumno a;
        /*for(int x = 0; x < losAlumnos.size(); ++x){
            a = losAlumnos.get(x);
            Log.d("TAG_", "Nombre " + a.getNombre());
        }*/

        for(Alumno a : losAlumnos){
            Log.d("TAG_", "Nombre " + a.getNombre());
        }

    }

    private void crearAlumno(){

        if(validarDatos()) {
            Alumno alumno = new Alumno();
            int matricula = Integer.parseInt(etMatricula.getText().toString());

            alumno.setMatricula(matricula);
            alumno.setNombre(etNombre.getText().toString());
            alumno.setCorreo(etCorreo.getText().toString());
            alumno.setCarrera(etCarrera.getText().toString());

            losAlumnos.add(alumno);
            limpiarPantalla();
            btnAvanzar.setEnabled(true);
            Toast.makeText(this, "Alumno agregado", Toast.LENGTH_LONG).show();
        }
    }

    private void limpiarPantalla(){
        etMatricula.setText("");
        etNombre.setText("");
        etCorreo.setText("");
        etCarrera.setText("");

        etMatricula.requestFocus();
    }

    private void avanzar(){
        mostrarAlumno();
        if(indice < losAlumnos.size() - 1) {
            indice++;
        }else{
            btnAvanzar.setEnabled(false);
            btnRetroceder.setEnabled(true);
        }
    }

    private void retroceder(){
        mostrarAlumno();
        if(indice > 0) {
            indice--;
        }else {
            btnRetroceder.setEnabled(false);
            btnAvanzar.setEnabled(true);
        }
    }

    private void mostrarAlumno(){
        if(losAlumnos.size() > 0) {
            Alumno alumno = losAlumnos.get(indice);
            etMatricula.setText(String.valueOf(alumno.getMatricula()));
            etNombre.setText(alumno.getNombre());
            etCorreo.setText(alumno.getCorreo());
            etCarrera.setText(alumno.getCarrera());
        }
    }

    private void eventos(){
        btnAce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearAlumno();
            }
        });

        btnSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avanzar();
            }
        });

        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retroceder();
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListadoActivity.class);
                i.putExtra("listado", losAlumnos);
                i.putExtra("nombre", "maria jesus");
                i.putExtra("edad", 25);
                startActivity(i);
            }
        });

    }

}