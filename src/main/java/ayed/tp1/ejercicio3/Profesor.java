package ayed.tp1.ejercicio3;

public class Profesor {
    private String nombre, apellido, email, facultad, catedra;

    public Profesor(String nombre, String apellido, String facultad, String catedra) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = nombre + apellido + "@info.unlp.edu.ar";
        this.facultad = facultad;
        this.catedra = catedra;
    }

    public String tusDatos() {
        return "Nombre: " + getNombre() +
                ", apellido: " + getApellido() +
                ", email: " + getEmail() +
                ", facultad: " + getFacultad() +
                ", catedra: " + getCatedra();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }
}
