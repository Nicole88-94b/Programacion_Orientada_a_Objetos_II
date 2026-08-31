package app;


import gestor.ControladorDeEnvios;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //--------------------------------------REPARTIDORES DISPONIBLES--------------------------------
        ControladorDeEnvios controles = new ControladorDeEnvios();
        List<Repartidor> repartidores = new ArrayList<>();
        repartidores.add(new Repartidor("Valentina Contreras", true, false));
        repartidores.add(new Repartidor("Camilo Henríquez", true, true));
        repartidores.add(new Repartidor("Tomás Liencura", false, false));


//------------------------------------PEDIDOS SOLICITADOS-------------------------------------------
        PedidoComida pedido1 = new PedidoComida("PC-001",
                "Avenida Los Lagos 120",
                "Pedido de comida", 30,
                repartidores.get(1));

        PedidoEncomienda pedido2 = new PedidoEncomienda("PE-001",
                "Calle Vicente Pérez Rosales 450",
                "Pedido de encomienda", 12, "ACEPTADA",
                30, repartidores.get(2));

        PedidoExpress pedido3 = new PedidoExpress("PX-001",
                "Pasaje Puerto Varas 85",
                "Pedido express", 6,
                repartidores.get(1));


        //----------------------------------------PEDIDOS DE COMIDA-----------------------------------------
        System.out.println("\n===================PEDIDO COMIDA=================");
        System.out.println("Buscando un repartidor con mochila térmica...");
        System.out.println(pedido1.asignarRepartidor());
        System.out.println("Código de su pedido: " + pedido1.getIdPedido());
        System.out.println("Verificando disponibilidad...");
        controles.registrarPedido(pedido1);
        boolean reservado1 = controles.reservarPedido(pedido1);
        if (reservado1) {
            System.out.println("Su pedido: " + pedido1.getIdPedido() + " ha sido reservado correctamente.");
            controles.despacharPedido(pedido1);
            System.out.println("Despachando pedido " + pedido1.getIdPedido() + "...");
            System.out.println(pedido1.mostrarResumen());
            System.out.println("Tiempo de entrega estimado: " + pedido1.calcularTiempoEntrega() + " minutos.");
            System.out.println("=========================================================");
        } else {
            controles.cancelarPedido(pedido1);
            System.out.println("Lo sentimos, no fue posible reservar el pedido porque no cumple los requisitos de envío.");
        }


        //---------------------------------------------ENCOMIENDAS-----------------------------------------------
        System.out.println("\n===================PEDIDO ENCOMIENDA===================");
        System.out.println("Buscando un repartidor disponible...");
        System.out.println(pedido2.asignarRepartidor());
        controles.registrarPedido(pedido2);
        System.out.println("Código de su pedido: " + pedido2.getIdPedido());
        boolean reservado2 = controles.reservarPedido(pedido2);
        if (reservado2) {
            System.out.println("Su pedido: " + pedido2.getIdPedido() + " ha sido reservado correctamente.");
            controles.despacharPedido(pedido2);
            System.out.println("Despachando pedido " + pedido2.getIdPedido() + "...");
            System.out.println(pedido2.mostrarResumen());
            System.out.println("Tiempo de entrega estimado: " + pedido2.calcularTiempoEntrega() + " minutos.");
            System.out.println("=========================================================");
        } else {
            controles.cancelarPedido(pedido2);
            System.out.println("Lo sentimos, no fue posible reservar el pedido porque no cumple los requisitos de envío.");

        }


        //----------------------- PEDIDOS EXPRESS ------------------------------
        System.out.println("\n===================PEDIDO EXPRESS===================");
        System.out.println("Buscando un repartidor disponible...");
        System.out.println(pedido3.asignarRepartidor("Camila Parada"));
        controles.registrarPedido(pedido3);
        System.out.println("Código de su pedido: " + pedido3.getIdPedido());
        boolean reservado3 = controles.reservarPedido(pedido3);
        if (reservado3) {
            System.out.println("Su pedido " + pedido3.getIdPedido() + " quedó reservado y está a la espera de despacho.");
            System.out.println(pedido3.mostrarResumen());
            System.out.println("Tiempo de entrega estimado: " + pedido3.calcularTiempoEntrega() + " minutos.");
            System.out.println("=========================================================");
        } else {
            controles.cancelarPedido(pedido3);
            System.out.println("Lo sentimos, no fue posible reservar el pedido porque no cumple los requisitos de envío.");
        }

        //----------------------HISTORIAL----------------------------

        System.out.println("\n================Historial de operaciones===================");

        for (String evento : controles.verHistorial()) {
            System.out.println(evento);
        }

        System.out.println("\n-----------------------Desglose de los pedidos-----------------------");
        controles.mostrarPedidosReservados();
        controles.mostrarPedidosDespachados();
        controles.mostrarPedidosCancelados();


    }
}
