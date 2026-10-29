/*
 * Copyright (c) 2026. Programacion Orientada al Objeto, DISC, UCN, Chile.
 */

package cl.ucn.disc.poo.restaurante.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el Pedido de una Mesa.
 */
public final class Pedido implements Facturable {

    /**
     * Mesa del Pedido.
     */
    private final int mesa;

    /**
     * Contenedor de Productos.
     */
    private final List<Producto> productos = new ArrayList<>();

    /**
     * Constructor de un Pedido.
     *
     * @param mesa asociada al Pedido.1
     */
    public Pedido(int mesa) {
        // validacion
        if (mesa < 1) {
            throw new IllegalArgumentException("Numero de mesa no valido");
        }
        this.mesa = mesa;
    }

    /**
     * @return el numero de la mesa.
     */
    public int getMesa() {
        return this.mesa;
    }

    /**
     *
     * @return la cantidad de Productos del Pedido asociado a la mesa.
     */
    public int getCantidadProductos() {
        // los Productos que estan en la lista.
        return this.productos.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregar(Producto producto) {
        // validacion!
        if (producto == null) {
            throw new IllegalArgumentException("No se permite Producto vacio");
        }
        // agrego el Producto al Pedido.
        this.productos.add(producto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calcularTotal() {
        // monto del pedido
        double total = 0.0;

        // recorrer el listado de productos
        for (Producto p : this.productos) {
            // sumo el precio del Producto
            total += p.getPrecio();
            // sumo el impuesto del Producto
            total += p.calcularImpuesto();
        }

        return total;
    }
}
