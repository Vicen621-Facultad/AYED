package ayed.tp5.ejercicio5;

import java.util.Objects;

public class Persona {
    private String nombre;
    private TipoPersona tipo;
    private String domicilio;
    private boolean cobroJubilacion;

    public Persona(String nombre, TipoPersona tipo, String domicilio, boolean cobroJubilacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.domicilio = domicilio;
        this.cobroJubilacion = cobroJubilacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoPersona getTipo() {
        return tipo;
    }

    public void setTipo(TipoPersona tipo) {
        this.tipo = tipo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public boolean isCobroJubilacion() {
        return cobroJubilacion;
    }

    public void setCobroJubilacion(boolean cobroJubilacion) {
        this.cobroJubilacion = cobroJubilacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return isCobroJubilacion() == persona.isCobroJubilacion() && Objects.equals(getNombre(), persona.getNombre()) && getTipo() == persona.getTipo() && Objects.equals(getDomicilio(), persona.getDomicilio());
    }

    public enum TipoPersona {
        EMPLEADO,
        JUBILADO
    }
}
