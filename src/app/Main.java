package app;


import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void  main(String[] args) {
        List <Repartidor> repartidores = new ArrayList <>();
            repartidores.add(new Repartidor ("Valentina", true, false));
            repartidores.add(new Repartidor ("Camilo", true, true));
            repartidores.add(new Repartidor ("Tomás", false, true));


        Pedido pedido1 = new PedidoComida("PC-001",
                "Avenida Los Lagos 120",
                "Pedido de comida",
                repartidores.get(1));

        Pedido pedido2 = new PedidoEncomienda("PE-001",
                "Calle Vicente Pérez Rosales 450",
                "Pedido de encomienda",
                "ACEPTADA",
                12.5,
                repartidores.get(0));

        Pedido pedidoExpress = new PedidoExpress("PX-001",
                "Pasaje Puerto Varas 85",
                "Pedido express",
                repartidores.get(2));




    }
}
