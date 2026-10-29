/*
 * Copyright (c) 2026. Programacion Orientada al Objeto, DISC, UCN, Chile.
 */

package cl.ucn.disc.poo.restaurante.services;

import cl.ucn.disc.poo.restaurante.model.Producto;

/**
 * Operaciones de Sistema del Restaurante.
 */
public interface Sistema {

    /**
     * Dado el numero de mesa, retorna el total a pagar.
     *
     * @param mesa a buscar.
     * @return el monto total a pagar en pesos.
     */
    int totalPagar(int mesa);

    /**
     * Agrega un Producto a una mesa identificada por su numero.
     *
     * @param producto a agregar.
     * @param mesa     indicada.
     */
    void agregarProductoAMesa(Producto producto, int mesa);

}
