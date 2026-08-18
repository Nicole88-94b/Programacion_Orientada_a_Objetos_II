package model;

public class PedidoExpress extends Pedido {
private Repartidor repartidor;

    public PedidoExpress(String idPedido, String direccionEntrega, String tipoPedido, Repartidor repartidor) {
        super(idPedido, direccionEntrega, tipoPedido);
        setRepartidor(repartidor);
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
        if (!repartidor.isDisponible()){
            return "Repartidor ocupado";
        }
        return "Se ha verificado disponibilidad del repartidor. Repartidor asignado.";
    }


}
