# SpeedFast

Proyecto desarrollado en Java para representar parte del funcionamiento de la empresa de reparto a domicilio SpeedFast.

El sistema trabaja con pedidos de comida, encomiendas y compras express. Cada tipo de pedido presenta reglas particulares para asignar un repartidor y calcular su tiempo estimado de entrega.

## Clases implementadas

### Pedido

Clase abstracta que contiene los atributos comunes de todos los pedidos:

- Identificador del pedido.
- Dirección de entrega.
- Tipo de pedido.
- Distancia en kilómetros.

También contiene:

- `mostrarResumen()`: presenta la información general del pedido.
- `asignarRepartidor()`: entrega un mensaje general de asignación.
- `asignarRepartidor(String nombreRepartidor)`: versión sobrecargada que permite indicar el nombre del repartidor.
- `calcularTiempoEntrega()`: método abstracto implementado de manera diferente en cada clase hija.

### PedidoComida

Representa los pedidos provenientes de restaurantes.

- Comprueba que el repartidor tenga mochila térmica.
- Calcula el tiempo de entrega utilizando 15 minutos base más 2 minutos por cada kilómetro.

### PedidoEncomienda

Representa el envío de documentos o paquetes.

- Valida el peso y el estado del embalaje.
- Calcula el tiempo utilizando 20 minutos base más 1,5 minutos por cada kilómetro.
- El resultado del cálculo se ajusta a un número entero.

### PedidoExpress

Representa pedidos de supermercado o farmacia.

- Comprueba la disponibilidad inmediata del repartidor.
- Considera un tiempo base de 10 minutos.
- Si la distancia supera los 5 kilómetros, agrega 5 minutos adicionales.

### Repartidor

Representa a los repartidores disponibles para los pedidos.

Contiene información sobre:

- Nombre del repartidor.
- Disponibilidad.
- Posesión de mochila térmica.

### Main

Crea objetos de cada tipo de pedido y muestra en consola:

- La asignación del repartidor.
- El resumen del pedido.
- La distancia de entrega.
- El tiempo estimado según el tipo de pedido.

## Conceptos de programación aplicados

- Encapsulamiento mediante atributos privados, getters y setters.
- Validación de datos con `IllegalArgumentException`.
- Herencia entre la clase `Pedido` y sus clases derivadas.
- Clase y método abstractos.
- Sobrescritura de métodos con `@Override`.
- Sobrecarga del método `asignarRepartidor()`.
- Polimorfismo mediante referencias de tipo `Pedido`.
- Composición entre los pedidos y la clase `Repartidor`.
- Reutilización del método `mostrarResumen()` mediante `super`.

## Cálculo de tiempos

| Tipo de pedido | Cálculo |
|---|---|
| Comida | 15 minutos + 2 minutos por kilómetro |
| Encomienda | 20 minutos + 1,5 minutos por kilómetro |
| Express | 10 minutos y 5 adicionales si supera 5 kilómetros |

## Validaciones

El proyecto incluye validaciones para evitar:

- Distancias iguales o inferiores a cero.
- Repartidores nulos.
- Nombres nulos o en blanco.
- Encomiendas con peso inválido.
- Estados de embalaje no aceptados.
- Asignación de pedidos de comida sin mochila térmica.
- Asignación express a repartidores ocupados.

## Instrucciones de ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Abrir la clase `Main`, ubicada en el paquete `app`.
3. Ejecutar el método `main()`.
4. Revisar los resultados generados en consola.

## Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Git
- GitHub

## Autora

Nicole Ortega