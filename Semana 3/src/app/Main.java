package app;


import model.*;

import java.util.List;

public class Main {
    static void main(String[] args) {

        Repartidor repartidor = new Repartidor("Defecto", true, true);
        List<Repartidor> repartidores = repartidor.registrarRepartidor();
        repartidores.add(new Repartidor("Valentina Contreras", true, false));
        repartidores.add(new Repartidor("Camilo Henríquez", true, true));
        repartidores.add(new Repartidor("Tomás Liencura", false, false));

        for (Repartidor r : repartidores) {
            r.registrarRepartidor();
            System.out.println(r);
        }


        PedidoComida pedido1 = new PedidoComida("PC-001",
                "Avenida Los Lagos 120",
                "Pedido de comida", 30,
                repartidores.get(0));

        System.out.println("\n===================PEDIDO DE COMIDA=================");
        System.out.println("Buscando un repartidor con mochila térmica...");
        System.out.println(pedido1.asignarRepartidor(repartidores.get(2).setNombreRepartidor("Camila Parada")));
        System.out.println("Verificando disponibilidad...");
        boolean validacionPrimaria = pedido1.cancelar();
        if (validacionPrimaria) {
            String validacionSecundaria = pedido1.cancelar() ? "Repartidor disponible" :
                    "No se ha verificado la disponibilidad del repartidor.";

            System.out.println(validacionSecundaria);
            System.out.println(pedido1.mostrarResumen());
            System.out.println("Tiempo de entrega estimado: " + pedido1.calcularTiempoEntrega() + " minutos.");
            System.out.println("=========================================================");
        } else {
            System.out.println("No ha sido posible asignarle el repartidor. Lo sentimos, pedido cancelado.");
        }

        PedidoEncomienda pedido2 = new PedidoEncomienda("PE-001",
                "Calle Vicente Pérez Rosales 450",
                "Pedido de encomienda", 12,
                "ACEPTADA",
                30,
                repartidores.get(1));

        System.out.println("\n===================PEDIDO DE ENCOMIENDA===================");
        System.out.println("Buscando un repartidor...");
        System.out.println(pedido2.asignarRepartidor(repartidores.get(2).setNombreRepartidor("Fernando León")));
        System.out.println("Verificando disponibilidad...");
        boolean validado2 = pedido2.cancelar();
        if (validado2) {
            System.out.println("Repartidor disponible");
            System.out.println(pedido2.mostrarResumen());
            System.out.println("Tiempo de entrega estimado: " + pedido2.calcularTiempoEntrega() + " minutos.");
            System.out.println("=========================================================");
        } else {
            System.out.println("No ha sido posible asignarle el repartidor. Lo sentimos, pedido cancelado.");
        }


        PedidoExpress pedido3 = new PedidoExpress("PX-001",
                "Pasaje Puerto Varas 85",
                "Pedido express", 6,
                repartidores.get(1));

        System.out.println("\n===================PEDIDO EXPRESS===================");
        System.out.println("Buscando un repartidor...");
        System.out.println("Verificando disponibilidad...");
        boolean validado3 = pedido3.cancelar();
        if (validado3) {
            System.out.println(pedido3.asignarRepartidor());
            System.out.println(pedido3.mostrarResumen());
            System.out.println("Tiempo de entrega estimado: " + pedido3.calcularTiempoEntrega() + " minutos.");
            System.out.println("=========================================================");
        } else {
            System.out.println("No ha sido posible asignarle el repartidor. Lo sentimos, pedido cancelado.");
        }


    }
}
