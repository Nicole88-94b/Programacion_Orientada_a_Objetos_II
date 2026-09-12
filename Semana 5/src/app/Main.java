package app;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        //--------------------------------------REPARTIDORES DISPONIBLES--------------------------------
        Repartidor valentina = new Repartidor("Valentina Contreras", true, true);
        Repartidor camilo = new Repartidor("Camilo Henríquez", true, true);
        Repartidor tomas = new Repartidor("Tomás Liencura", false, true);

        List<Repartidor> repartidores = new ArrayList<>();
        repartidores.add(valentina);
        repartidores.add(camilo);
        repartidores.add(tomas);


        //------------------------------------PEDIDOS SOLICITADOS-------------------------------------------
        Pedido pedidoDeComida1 = new PedidoComida("PC-001",
                "Avenida Los Lagos #120",
                "Pedido de comida", 30, valentina);
        Pedido pedidoDeComida2 = new PedidoComida("PC-002", "Manuel Matta #333", "Pedido comida",
                20, camilo);

        Pedido pedidoEncomienda1 = new PedidoEncomienda("PE-001",
                "Calle Vicente Pérez Rosales 450",
                "Pedido de encomienda", 12, "ACEPTADA",
                30, valentina);

        Pedido pedidoEncomienda2 = new PedidoEncomienda("PE-002",
                "Amthauer #523",
                "Pedido de encomienda", 8, "ACEPTADA",
                10, tomas);

        Pedido pedidoExpress1 = new PedidoExpress("PX-001",
                "Pasaje Puerto Varas 85",
                "Pedido express", 6,
                camilo);
        Pedido pedidoExpress2 = new PedidoExpress("PX-002",
                "Freire #455, Casa interior \"A\"",
                "Pedido express", 3,
                tomas);


        //----------------------------------------PEDIDOS-----------------------------------------
        valentina.asignarPedido(pedidoDeComida1);
        valentina.asignarPedido(pedidoEncomienda1);

        camilo.asignarPedido(pedidoExpress1);
        camilo.asignarPedido(pedidoDeComida2);

        tomas.asignarPedido(pedidoEncomienda2);
        tomas.asignarPedido(pedidoExpress2);

        System.out.println("--------------------------Inicio de la simulación--------------------------");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (Repartidor repartidor : repartidores) {
            executor.execute(repartidor);
        }

        executor.shutdown();
        boolean finalizaron = false;

        try {
            finalizaron = executor.awaitTermination(30, TimeUnit.SECONDS);

            if (!finalizaron) {
                System.out.println("El tiempo de espera fue superado.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.out.println("La ejecución principal fue interrumpida.");
        }

        if (finalizaron) {
            System.out.println("Todos los repartidores finalizaron sus entregas.");
        }
    }
}
