/*
 * Copyright (c) 2026. Programacion Orientada al Objeto, DISC, UCN, Chile.
 */

package cl.ucn.disc.poo.restaurante.model;

/**
 * Clase que representa el Producto de un Restaurante.
 */
public abstract class Producto {

    /**
     * Nombre del Producto.
     */
    private final String nombre;

    /**
     * Precio del Producto.
     */
    private final int precio;

    /**
     * Constructor de un Producto.
     *
     * @param nombre del Producto.
     * @param precio del Producto.
     */
    public Producto(String nombre, int precio) {
        // Validacion de nombre,
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre del Producto vacio!!");
        }

        // TODO: Preguntar al cliente si se permite la venta
        //       de Productos con valor cero.
        if (precio < 0) {
            throw new IllegalArgumentException("No se permiten precios negativos");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * @return el nombre.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return el precio.
     */
    public int getPrecio() {
        return this.precio;
    }

    /**
     * Obliga a que las clases hijas implementen el metodo.
     *
     * @return el impuesto del Producto.
     */
    public abstract double calcularImpuesto();

}
