package model;


public class PedidoComida  extends Pedido {
    private Repartidor repartidor;

    public PedidoComida(String idPedido, String direccionEntrega, String tipoPedido, Repartidor repartidor)  {
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
    return "El repartidor tiene sus implementos. Repartidor asignado";
    }

    @Override
    public String toString() {
        return super.toString() + "\nRepartidor de su pedido: "+ repartidor.getNombreRepartidor() + ".";
    }



}
