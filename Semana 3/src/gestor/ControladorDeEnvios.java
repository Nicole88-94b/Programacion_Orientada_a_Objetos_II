package gestor;

import interfaces.Rastreable;
import interfaces.Despachable;
import interfaces.Cancelable;
import model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios implements Rastreable {

    private List<Pedido> pedidos;
    private List<String> historial;


    public ControladorDeEnvios() {
        this.pedidos = new ArrayList<>();
        this.historial = new ArrayList<>();

    }

    public boolean registrarPedido(Pedido pedido) {
        if (pedido == null) {
            return false;
        }

        for (Pedido pedidoRegistrado : pedidos) {
            if (pedidoRegistrado.getIdPedido().equals(pedido.getIdPedido())) {
                return false;
            }
        }

        pedidos.add(pedido);
        historial.add("Pedido " + pedido.getIdPedido() + " registrado.");

        return true;
    }

    public boolean reservarPedido(Pedido pedido) {
        if (pedido == null || !pedidos.contains(pedido)) {
            return false;
        }
        boolean reservado = pedido.reservar();
        if (reservado) {
            historial.add("Pedido " + pedido.getIdPedido() + " reservado.");
        }
        return reservado;
    }

    public boolean despacharPedido(Pedido pedido) {
        if (pedido == null || !pedidos.contains(pedido) || !(pedido instanceof Despachable)) {
            return false;
        }

        Despachable despachable = (Despachable) pedido;
        boolean despachado = despachable.despachar();

        if (despachado) {
            historial.add("Pedido " + pedido.getIdPedido() + " despachado.");
        }

        return despachado;
    }

    public boolean cancelarPedido(Pedido pedido) {
        if (pedido == null || !pedidos.contains(pedido) || !(pedido instanceof Cancelable)) {
            return false;
        }

        Cancelable cancelable = (Cancelable) pedido;
        boolean cancelado = cancelable.cancelar();

        if (cancelado) {
            historial.add("Pedido " + pedido.getIdPedido() + " cancelado.");
        }

        return cancelado;
    }

    public void mostrarPedidosReservados() {
        System.out.println("=========== PEDIDOS RESERVADOS ===========");

        for (Pedido pedido : pedidos) {
            if (pedido.isReservado() && !pedido.isDespachado() && !pedido.isCancelado()) {
                System.out.println(pedido.getIdPedido());
            }
        }
    }

    public void mostrarPedidosDespachados() {
        System.out.println("=========== PEDIDOS DESPACHADOS ===========");
        for (Pedido pedido : pedidos) {
            if (pedido.isDespachado()) {
                System.out.println(pedido.getIdPedido());
            }
        }
    }

    public void mostrarPedidosCancelados() {
        System.out.println("=========== PEDIDOS CANCELADOS ===========");
        for (Pedido pedido : pedidos) {
            if (pedido.isCancelado()) {
                System.out.println(pedido.getIdPedido());
            }
        }
    }


    @Override
    public List<String> verHistorial() {
        return new ArrayList<>(historial);
    }
}
