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

        return nombreRepartidor +
                "\nDisponibilidad: " + estadoDisponibilidad + ".";
    }
}
