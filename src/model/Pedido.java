package model;

public abstract class Pedido {
    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private int distanciaKilometros;

    public Pedido(String idPedido, String direccionEntrega, String tipoPedido, int distanciaKilometros) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.tipoPedido = tipoPedido;
        setDistanciaKilometros(distanciaKilometros);

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

    public String mostrarResumen() {
        return toString();
    }

    @Override
    public String toString() {
        return "\nPedido inicializado... " +
                "\n\n=======Resumen de su pedido=======" +
                "\nID del pedido: " + idPedido +
                "\nDirección de la Entrega: " + direccionEntrega +
                "\nTipo de Pedido: " + tipoPedido +
                "\nDistancia: " + distanciaKilometros + " km";

    }

    public String asignarRepartidor() {
        return "Espere mientras se asigna un repartidor...";
    }

    public String asignarRepartidor(String nombreRepartidor) throws IllegalArgumentException {
        if (nombreRepartidor == null || nombreRepartidor.isBlank()) {
            throw new IllegalArgumentException("Ingrese un nombre de repartidor válido.");
        }
        return "El repartidor " + nombreRepartidor + " fue asignado manualmente al pedido.";
    }

    public abstract int calcularTiempoEntrega();
}
