package gestor;

import interfaces.Cancelable;
import interfaces.Despachable;
import interfaces.Rastreable;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios {
private List<Cancelable> cancelado;
private List<Rastreable> rastreable;
private List<Despachable>  despachable;


public ControladorDeEnvios(Cancelable cancelado, Rastreable rastreable,Despachable despachable) {
    this.cancelado = new ArrayList<>();
    this.rastreable = new ArrayList<>();
    this.despachable = new ArrayList<>();
}

public void cancelarTodos(Cancelable cancelado) {

}


}
