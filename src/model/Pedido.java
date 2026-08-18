package model;

public abstract class Pedido {
    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;

    public Pedido(String idPedido, String direccionEntrega, String tipoPedido) {
    this.idPedido = idPedido;
    this.direccionEntrega = direccionEntrega;
    this.tipoPedido = tipoPedido;

    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String toString() {
        return "Pedido inicializado: " +
                "\nID del pedido: " + idPedido +
                "\nDirección de la Entrega: " + direccionEntrega +
                "\nTipo de Pedido: " + tipoPedido;

    }

    public String asignarRepartidor() {
        return "Espere mientras se asigna un repartidor...";
    }

    public String asignarRepartidor(String nombreRepartidor) throws IllegalArgumentException {
        if (nombreRepartidor == null || nombreRepartidor.isBlank()) {
            throw new IllegalArgumentException("Ingrese un nombre de repartidor válido.");
        }
        return "El repartidor " +  nombreRepartidor + " fue asignado manualmente al pedido.";
    }
}
