package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Repartidor implements Runnable {
    private String nombreRepartidor;
    private boolean tieneMochilaTermica;
    private boolean disponible;
    private List<Pedido> pedidosAsignados;

    public Repartidor(String nombreRepartidor, boolean tieneMochilaTermica, boolean disponible) {
        setNombreRepartidor(nombreRepartidor);
        setTieneMochilaTermica(tieneMochilaTermica);
        setDisponible(disponible);
        this.pedidosAsignados = new ArrayList<>();
    }

    public String getNombreRepartidor() {
        return nombreRepartidor;
    }

    public void setNombreRepartidor(String nombreRepartidor) throws IllegalArgumentException {
        if (nombreRepartidor == null || nombreRepartidor.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del repartidor es obligatorio.");
        }
        this.nombreRepartidor = nombreRepartidor;
    }

    public boolean isTieneMochilaTermica() {
        return tieneMochilaTermica;
    }

    public void setTieneMochilaTermica(boolean tieneMochilaTermica) {
        this.tieneMochilaTermica = tieneMochilaTermica;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        String estadoDisponibilidad = disponible ? "Está disponible el repartidor" : "El repartidor está ocupado";
        String estadoMochila = tieneMochilaTermica ? "Correcto." : "Incorrecto: no tiene mochila térmica.";

        return "Nombre del repartidor: " + nombreRepartidor +
                "\nDisponibilidad: " + estadoDisponibilidad + "."
                + "\nPosee mochila térmica: " + estadoMochila;
    }

    public void asignarPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }

        pedidosAsignados.add(pedido);
    }

    @Override
    public void run() {
        for (Pedido pedido : pedidosAsignados) {
            System.out.println("[Repartidor: " + nombreRepartidor +
                    "] ====> Entregando " + pedido.getTipoPedido() + " #" + pedido.getIdPedido() + "...");
            int tiempoEspera = ThreadLocalRandom.current().nextInt(1000, 3001);

            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Repartidor: " + nombreRepartidor +
                        "] ====> Lo sentimos. Entrega interrumpida.");
                return;
            }
            System.out.println("[Repartidor: " + nombreRepartidor +
                    "] " + pedido.getTipoPedido() + " #" + pedido.getIdPedido() + " entregado.");
        }

    }
}
