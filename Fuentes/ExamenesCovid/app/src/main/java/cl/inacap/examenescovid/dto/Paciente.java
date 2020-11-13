package cl.inacap.examenescovid.dto;

import androidx.annotation.NonNull;

public class Paciente {

    private String rut;
    private String nombre;
    private String apellido;
    private String fechaExamen;
    private String areaTrabajo;
    private boolean sintomas;
    private boolean tos;
    private double temperatura;
    private int presionArterial;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public boolean isSintomas() {
        return sintomas;
    }

    public void setSintomas(boolean sintomas) {
        this.sintomas = sintomas;
    }

    public boolean isTos() {
        return tos;
    }

    public void setTos(boolean tos) {
        this.tos = tos;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(int presionArterial) {
        this.presionArterial = presionArterial;
    }

    public void setSintomasInt(int i){
        if(i==0){
            this.sintomas = false;
        }
        if(i==1){
            this.sintomas= true;
        }
    }

    public void setTosInt(int i){

        if(i==0){
            this.tos = false;
        }
        if(i==1){
            this.tos = true;
        }
    }

    @NonNull
    @Override
    public String toString() {

        return this.rut +" - "+ this.nombre +" - "+ this.apellido +" - "+this.fechaExamen;
    }
}
