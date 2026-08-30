package model;

import interfaces.Cancelable;
import interfaces.Despachable;

public class PedidoExpress extends Pedido implements Cancelable, Despachable {
    private Repartidor repartidor;

    public PedidoExpress(String idPedido, String direccionEntrega, String tipoPedido, int distanciaKilometros,
                         Repartidor repartidor) {
        super(idPedido, direccionEntrega, tipoPedido, distanciaKilometros);
        setRepartidor(repartidor);
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
        if (!repartidor.isDisponible()) {
            return "Repartidor ocupado.";
        }
        return "Se ha verificado disponibilidad del repartidor. \nRepartidor asignado.";
    }

    @Override
    public String asignarRepartidor(String nombreRepartidor) throws IllegalArgumentException {
        if (nombreRepartidor == null || nombreRepartidor.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingrese un nombre de repartidor válido.");
        }
        if (!repartidor.isDisponible()) {
            return "No se puede asignar a " + nombreRepartidor + ": el repartidor está ocupado.";
        }

        return "Repartidor cercano con disponibilidad inmediata encontrado. " +
                "Pedido asignado a " + nombreRepartidor + ".";
    }

    @Override
    public int calcularTiempoEntrega() {
        int tiempoBaseDelPedido = 10;
        int tiempoEntrega = tiempoBaseDelPedido;
        if (getDistanciaKilometros() >5) {
            tiempoEntrega = tiempoBaseDelPedido + 5;
        }
        return tiempoEntrega;
    }

    @Override
    public String mostrarResumen() {
        return super.mostrarResumen();
    }

    @Override
    public boolean cumpleRequisitos() {
        return repartidor.isDisponible();
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
