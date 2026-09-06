package model;


import interfaces.Cancelable;
import interfaces.Despachable;

public class PedidoComida extends Pedido implements Despachable, Cancelable {
    private Repartidor repartidor;

    public PedidoComida(String idPedido, String direccionEntrega, String tipoPedido, int distanciaKilometros,
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
        if (!repartidor.isTieneMochilaTermica()) {
            return "No es posible asignar un repartidor sin una mochila térmica.";
        }
        return "Repartidor " + repartidor.getNombreRepartidor() + " encontrado.";

    }

    @Override
    public String asignarRepartidor(String nombreRepartidor) throws IllegalArgumentException {
        if (nombreRepartidor == null || nombreRepartidor.trim().isEmpty()) {
            throw new IllegalArgumentException("Ingrese un nombre de repartidor válido.");
        }
        boolean verificarMochila = repartidor.isTieneMochilaTermica();
        if (!verificarMochila) {
            return "No se puede asignar a " + nombreRepartidor + ": no tiene mochila térmica.";
        }
        return "Mochila térmica verificada. Pedido asignado a " +
                nombreRepartidor + ".";
    }

    @Override
    public int calcularTiempoEntrega() {
        int tiempoBaseDelPedido = 15;
        int tiempoEntrega = tiempoBaseDelPedido + (getDistanciaKilometros() * 2);
        return tiempoEntrega;
    }

    @Override
    public String mostrarResumen() {
        String estadoMochila = repartidor.isTieneMochilaTermica() ? "Correcto." : "Incorrecto: no tiene mochila térmica.";
        return super.mostrarResumen() +
                "\nEstado de la mochila térmica: " + estadoMochila;
    }

    @Override
    public boolean cumpleRequisitos() {
        return repartidor.isTieneMochilaTermica() && repartidor.isDisponible();
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
