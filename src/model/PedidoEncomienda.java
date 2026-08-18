package model;


public class PedidoEncomienda extends Pedido{
private String estadoEmbalaje;
private double peso;
private Repartidor repartidor;

    public PedidoEncomienda(String idPedido, String direccionEntrega, String tipoPedido, String estadoEmbalaje,
                            double peso, Repartidor repartidor)  {
        super(idPedido, direccionEntrega, tipoPedido);
        setEstadoEmbalaje(estadoEmbalaje);
        setPeso(peso);
        setRepartidor(repartidor);

    }

    public String getEstadoEmbalaje() {
        return estadoEmbalaje;
    }

    public void setEstadoEmbalaje(String estadoEmbalaje) throws IllegalArgumentException {
        if  (estadoEmbalaje == null || estadoEmbalaje.isBlank() || !estadoEmbalaje.matches("ACEPTADA|RECHAZADA")) {
            throw new IllegalArgumentException("Estado del embalaje inválido. Ingrese 'ACEPTADA' o 'RECHAZADA'.");
        }
        this.estadoEmbalaje = estadoEmbalaje;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) throws IllegalArgumentException {
        if (peso <= 0 || peso > 50) {
            throw new IllegalArgumentException("Peso inválido. Registre un peso mayor a 0 y menor o igual a 50 kg.");
        }
        this.peso = peso;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) throws IllegalArgumentException {
        if (repartidor == null ) {
            throw new IllegalArgumentException("Repartidor inválido");
        }
        this.repartidor = repartidor;
    }

    @Override
    public String asignarRepartidor() {
        return "El repartidor tiene la capacidad de transporte. Repartidor asignado.";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEstado del embalaje: " + getEstadoEmbalaje() +
                "\nPeso de la encomienda: " + getPeso()
                + "\nRepartidor: " + repartidor.getNombreRepartidor() + ".";
    }
}
