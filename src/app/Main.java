package app;


import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Repartidor> repartidores = new ArrayList<>();
        repartidores.add(new Repartidor("Valentina", true, false));
        repartidores.add(new Repartidor("Camilo", true, true));
        repartidores.add(new Repartidor("Tomás", false, true));


        Pedido pedido1 = new PedidoComida("PC-001",
                "Avenida Los Lagos 120",
                "Pedido de comida",
                repartidores.get(1));

        System.out.println("\n===================PEDIDO DE COMIDA=================");
        System.out.println(pedido1.asignarRepartidor());
        System.out.println(pedido1);
        System.out.println("=========================================================");

        Pedido pedido2 = new PedidoEncomienda("PE-001",
                "Calle Vicente Pérez Rosales 450",
                "Pedido de encomienda",
                "ACEPTADA",
                12.5,
                repartidores.get(0));

        System.out.println("\n===================PEDIDO DE ENCOMIENDA===================");
        System.out.println(pedido2.asignarRepartidor());
        System.out.println(pedido2);
        System.out.println("=========================================================");

        Pedido pedido3 = new PedidoExpress("PX-001",
                "Pasaje Puerto Varas 85",
                "Pedido express",
                repartidores.get(2));

        System.out.println("\n===================PEDIDO EXPRESS===================");
        System.out.println(pedido3.asignarRepartidor());
        System.out.println(pedido3);
        System.out.println("=========================================================");

        System.out.println("\n===================ASIGNACIÓN MANUAL DE REPARTIDOR===================");
        System.out.println(pedido1.asignarRepartidor("Camilo"));
        System.out.println(pedido2.asignarRepartidor("Valentina"));
        System.out.println(pedido3.asignarRepartidor("Tomás"));
        System.out.println("=========================================================");


    }
}
