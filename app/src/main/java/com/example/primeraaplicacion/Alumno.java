package com.example.primeraaplicacion;

public class Alumno {
    private int matricula;
    private String nombre;
    private String correo;
    private String carrera;

    public Alumno(){}

    public Alumno(int matricula, String nombre, String correo, String carrera){
        setMatricula(matricula);
        setNombre(nombre);
        setCorreo(correo);
        setCarrera(carrera);
    }

    //region Get y Set
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setCarrera(String carrera){
        this.carrera = carrera;
    }

    public int getMatricula(){
        return matricula;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public String getCarrera(){
        return carrera;
    }

    //endregion

}
