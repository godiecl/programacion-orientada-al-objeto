/*
 * Copyright (c) 2026. Programacion Orientada al Objeto, DISC, UCN, Chile.
 */

package cl.ucn.disc.poo.restaurante.model;

/**
 * Interfaz aplicada sobre todos los Pedidos.
 */
public interface Facturable {

    /**
     * Agregar un Producto a una Factura.
     *
     * @param producto a agregar.
     */
    void agregar(Producto producto);

    /**
     * @return el valor total de la Factura.
     */
    double calcularTotal();

}
