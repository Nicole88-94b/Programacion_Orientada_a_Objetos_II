package model;


import interfaces.Cancelable;
import interfaces.Despachable;


public class PedidoEncomienda extends Pedido implements Despachable, Cancelable {

    private String estadoEmbalaje;
    private double peso;
    private Repartidor repartidor;

    public PedidoEncomienda(String idPedido, String direccionEntrega, String tipoPedido, int distanciaKilometros, String estadoEmbalaje,
                            double peso, Repartidor repartidor) {
        super(idPedido, direccionEntrega, tipoPedido, distanciaKilometros);
        setEstadoEmbalaje(estadoEmbalaje);
        setPeso(peso);
        setRepartidor(repartidor);

    }

    public String getEstadoEmbalaje() {
        return estadoEmbalaje;
    }

    public void setEstadoEmbalaje(String estadoEmbalaje) throws IllegalArgumentException {
        if (estadoEmbalaje == null || estadoEmbalaje.trim().isEmpty() || !estadoEmbalaje.matches("ACEPTADA|RECHAZADA")) {
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
        if (repartidor == null) {
            throw new IllegalArgumentException("Repartidor inválido");
        }
        this.repartidor = repartidor;
    }

    @Override
    public String asignarRepartidor() {
        if (estadoEmbalaje.equals("RECHAZADA")) {
            return "Su encomienda ha sido rechazada.";
        }
        return "El repartidor tiene la capacidad de transporte. \nPedido asignado a: " + repartidor.getNombreRepartidor();
    }

    @Override
    public String asignarRepartidor(String nombreRepartidor) {
        if (nombreRepartidor == null || nombreRepartidor.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingrese un nombre válido.");
        }

        if (!"ACEPTADA".equals(estadoEmbalaje)) {
            return "No se puede asignar el pedido: embalaje rechazado.";
        }
            return "Peso y embalaje verificados. Pedido asignado a " + nombreRepartidor + ".";

    }



    @Override
    public int calcularTiempoEntrega() {
        int tiempoBaseDelPedido = 20;
        int tiempoEntrega = (int) Math.round(tiempoBaseDelPedido + (getDistanciaKilometros() * 1.5));
        return tiempoEntrega;
    }

    @Override
    public String mostrarResumen(){
        return super.mostrarResumen() +
                "\nEstado del embalaje: " + getEstadoEmbalaje() +
                "\nPeso de la encomienda: " + getPeso() + " kg";
    }

    @Override
    public boolean cumpleRequisitos() {
        return "ACEPTADA".equals(estadoEmbalaje) && repartidor.isDisponible();
    }

    @Override
    public boolean reservar() {
        if (!cumpleRequisitos()) {
            return false;
        }
        if (isReservado() || isDespachado() || isCancelado()) {
            return false;
        }
        setReservado();
        return true;
    }

    @Override
    public boolean despachar() {
        if (!isReservado() || isDespachado() || isCancelado()) {
            return false;
        }

        setDespachado();
        return true;
    }
    @Override
    public boolean cancelar() {
        if (isDespachado() || isCancelado()) {
            return false;
        }
        setCancelado();
        return true;
    }

}
