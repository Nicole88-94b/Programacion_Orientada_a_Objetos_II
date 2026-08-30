package model;

public abstract class Pedido {
    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private int distanciaKilometros;
    private boolean despachado;
    private boolean reservado;
    private boolean cancelado;

    public Pedido(String idPedido, String direccionEntrega, String tipoPedido, int distanciaKilometros) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
        setDistanciaKilometros(distanciaKilometros);
        //Estado inicial por defecto del pedido
        this.despachado = false;
        this.reservado = false;
        this.cancelado = false;

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

    public int getDistanciaKilometros() {
        return distanciaKilometros;
    }

    public void setDistanciaKilometros(int distanciaKilometros) throws IllegalArgumentException {

        if (distanciaKilometros <= 0) {
            throw new IllegalArgumentException("La distancia debe ser superior a 0.");
        }
        this.distanciaKilometros = distanciaKilometros;
    }

    public boolean isDespachado() {
        return despachado;
    }

    protected void setDespachado() {
        despachado = true;
    }

    public boolean isReservado() {
        return reservado;
    }

    protected void setReservado() {
        reservado = true;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    protected void setCancelado() {
        cancelado = true;
    }


    @Override
    public String toString() {
        return "\nPedido inicializado exitosamente: " +
                "\n----------------Resumen de su pedido----------------" +
                "\nID del pedido: " + idPedido +
                "\nDirección de la Entrega: " + direccionEntrega +
                "\nTipo de Pedido: " + tipoPedido +
                "\nDistancia: " + distanciaKilometros + " km";

    }

    public String asignarRepartidor() {
        return "Espere mientras se asigna un repartidor...";
    }

    public abstract String asignarRepartidor(String nombreRepartidor);

    public abstract int calcularTiempoEntrega();

    public String mostrarResumen() {
        return toString();
    }

    public abstract boolean cumpleRequisitos();

    public abstract boolean reservar();
}
