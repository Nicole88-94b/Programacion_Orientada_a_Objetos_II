package model;


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

    public void setNombreRepartidor(String nombreRepartidor) throws IllegalArgumentException {
        if (nombreRepartidor == null || nombreRepartidor.isBlank()) {
            throw new IllegalArgumentException("El nombre del repartidor es obligatorio.");
        }
        this.nombreRepartidor = nombreRepartidor;
    }

    public boolean isTieneMochilaTermica() {
        return tieneMochilaTermica;
    }

    public void setTieneMochilaTermica(boolean tieneMochilaTermica) {
         if (tieneMochilaTermica == true) {
             this.tieneMochilaTermica = tieneMochilaTermica;
         }
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
         if (disponible == true) {
             this.disponible = disponible;
         }
    }



    @Override
    public String toString() {
        String estadoMochila = tieneMochilaTermica ? "Tiene mochila" : "No tiene mochila";
        String estadoDisponibilidad = disponible ? "Está disponible el repartidor" : "El repartidor está ocupado";

        return "Nombre del repartidor asignado: " + nombreRepartidor + ";" +
                "\nMochila térmica: " + estadoMochila + ";" +
                "\nDisponibilidad:" + estadoDisponibilidad + ".";
    }
}
