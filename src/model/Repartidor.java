package model;


public class Repartidor {
    private String nombreRepartidor;
    private String mochilaRepartidor;
    private String disponibilidad;


     public Repartidor(String nombreRepartidor, String mochilaRepartidor, String disponibilidad) throws IllegalArgumentException {
        setNombreRepartidor(nombreRepartidor);
        setMochilaRepartidor(mochilaRepartidor);
        setDisponibilidad(disponibilidad);

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

    public String getMochilaRepartidor() {
        return mochilaRepartidor;
    }

    public void setMochilaRepartidor(String mochilaRepartidor) throws IllegalArgumentException {
        if (mochilaRepartidor == null || mochilaRepartidor.isBlank()) {
            throw new IllegalArgumentException("Debe asignar una mochila al repartidor.");
        }
        this.mochilaRepartidor = mochilaRepartidor;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) throws IllegalArgumentException {
        if  (disponibilidad == null || disponibilidad.isBlank() || !disponibilidad.matches("DISPONIBLE|OCUPADO")) {
            throw new IllegalArgumentException("Disponibilidad del repartidor inválida. Ingrese 'DISPONIBLE' u 'OCUPADO'.");
        }
        this.disponibilidad = disponibilidad;
    }


    @Override
    public String toString() {
        return "Nombre del repartidor asignado: " + nombreRepartidor + ";" +
                "estado mochila del repartidor" + mochilaRepartidor + ";" +
                "disponibilidad:" + disponibilidad + ".";
    }
}
