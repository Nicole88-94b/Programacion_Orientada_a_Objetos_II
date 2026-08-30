package model;


import java.util.ArrayList;
import java.util.List;

public class Repartidor {
    private String nombreRepartidor;
    private boolean tieneMochilaTermica;
    private boolean disponible;


     public Repartidor(String nombreRepartidor,boolean tieneMochilaTermica,boolean disponible)  {
        setNombreRepartidor(nombreRepartidor);
        setTieneMochilaTermica(tieneMochilaTermica);
        setDisponible(disponible);
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public String setNombreRepartidor(String nombreRepartidor) throws IllegalArgumentException {
        if (nombreRepartidor == null || nombreRepartidor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del repartidor es obligatorio.");
        }
            return this.nombreRepartidor = nombreRepartidor;
    }

    public boolean isTieneMochilaTermica() {
        return tieneMochilaTermica;
    }

    public void setTieneMochilaTermica(boolean tieneMochilaTermica) {
             this.tieneMochilaTermica = tieneMochilaTermica;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
             this.disponible = disponible;
    }

    @Override
    public String toString() {
        String estadoDisponibilidad = disponible ? "Está disponible el repartidor" : "El repartidor está ocupado";
        String estadoMochila = tieneMochilaTermica ? "Correcto." : "Incorrecto: no tiene mochila térmica.";

        return "Nombre del repartidor: " + nombreRepartidor +
                "\nDisponibilidad: " + estadoDisponibilidad + "."
                + "\nPosee mochila térmica: " + estadoMochila;
    }

}
