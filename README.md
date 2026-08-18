# SpeedFast

Proyecto formativo desarrollado en Java para representar el sistema de asignación de repartidores de la empresa SpeedFast.

El programa modela distintos tipos de pedidos y aplica herencia, sobrescritura, sobrecarga y polimorfismo para entregar un comportamiento diferente según las condiciones de cada servicio.

## Clases implementadas

- `Pedido`: clase base abstracta que contiene el identificador, la dirección de entrega y el tipo de pedido.
- `PedidoComida`: valida que el repartidor cuente con mochila térmica.
- `PedidoEncomienda`: valida el peso y el estado del embalaje.
- `PedidoExpress`: comprueba la disponibilidad inmediata del repartidor.
- `Repartidor`: representa al repartidor, su disponibilidad y si posee mochila térmica.
- `Main`: crea los objetos de ejemplo y muestra los resultados en consola.

## Conceptos aplicados

- Encapsulamiento mediante atributos privados y métodos getters y setters.
- Herencia entre la clase base `Pedido` y sus clases derivadas.
- Sobrescritura de `asignarRepartidor()` para personalizar el comportamiento de cada tipo de pedido.
- Sobrecarga de `asignarRepartidor(String nombreRepartidor)` para realizar una asignación indicando el nombre del repartidor.
- Polimorfismo al declarar objetos de las clases derivadas mediante referencias de tipo `Pedido`.
- Composición mediante la asociación de un objeto `Repartidor` con cada pedido.
- Validaciones con `IllegalArgumentException` para impedir datos no válidos.

## Funcionamiento

El programa crea un pedido de comida, un pedido de encomienda y un pedido express. Cada clase aplica sus propias condiciones al asignar un repartidor y presenta en consola los datos del pedido y el resultado de la asignación.

También se ejecuta la versión sobrecargada del método para demostrar la asignación manual mediante el nombre del repartidor.

## Instrucciones de ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Abrir la clase `Main`, ubicada en el paquete `app`.
3. Ejecutar el método `main()`.
4. Revisar la salida generada en consola.

## Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Git y GitHub

## Autora

Nicole Ortega
