package model;


public class PedidoComida extends Pedido {
    private Repartidor repartidor;

    public PedidoComida(String idPedido, String direccionEntrega, String tipoPedido, Repartidor repartidor) {
        super(idPedido, direccionEntrega, tipoPedido);
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
        return "Mochila térmica verificada. \nRepartidor asignado.";

    }

    @Override
    public String toString() {
        String estadoMochila = repartidor.isTieneMochilaTermica() ? "Tiene mochila." : "No tiene mochila.";

        return super.toString() +
                "\nRepartidor de su pedido: " + repartidor +
                "\nMochila térmica: " + estadoMochila;
    }

    @Override
    public String asignarRepartidor(String nombreRepartidor) throws IllegalArgumentException {
        if (nombreRepartidor == null || nombreRepartidor.isBlank()) {
            throw new IllegalArgumentException("Ingrese un nombre de repartidor válido.");
        }
        if (!repartidor.isTieneMochilaTermica()) {
            return "No se puede asignar a " + nombreRepartidor + ": no tiene mochila térmica.";
        }
        return "Mochila térmica verificada. Pedido asignado a " +
                nombreRepartidor + ".";
    }

}
