/*
 * Copyright (c) 2026. Programacion Orientada al Objeto, DISC, UCN, Chile.
 */

package cl.ucn.disc.poo.restaurante.services;

import cl.ucn.disc.poo.restaurante.model.Pedido;
import cl.ucn.disc.poo.restaurante.model.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion concreta del Sistema.
 */
public final class SistemaImpl implements Sistema {

    /**
     * El listado de Pedidos del Sistema.
     */
    private final List<Pedido> pedidos = new ArrayList<>();

    /**
     * Constructor.
     */
    public SistemaImpl(int numeroMaximoDeMesas) {

        // inicializar los pedidos de las mesas
        for (int i = 0; i < numeroMaximoDeMesas; i++) {
            // construyo el pedido de la mesa 1, 2, 3 ..
            Pedido pedido = new Pedido(i + 1);

            // agrego los pedidos vacios al sistema.
            this.pedidos.add(pedido);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int totalPagar(int mesa) {
        // validar
        if (mesa < 1) {
            throw new IllegalArgumentException("Mesa no valida");
        }

        // buscar la mesa
        for (Pedido p: this.pedidos) {
            // encontre la mesa
            if (p.getMesa() == mesa) {
                // TODO: Revisar la ley de redondeo
                return Math.toIntExact(Math.round(p.calcularTotal()));
            }
        }

        // no encontre la mesa
        throw new IllegalArgumentException("Mesa no encontrada!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void agregarProductoAMesa(Producto producto, int mesa) {
        // validaciones
        if (producto == null) {
            throw new IllegalArgumentException("Producto vacio");
        }
        if (mesa < 1) {
            throw new IllegalArgumentException("Mesa no valida");
        }

        // buscar la mesa
        for (int i = 0; i < this.pedidos.size(); i++) {
            // encontre la mesa
            Pedido p = this.pedidos.get(i);
            if (p.getMesa() == mesa) {
                // agrego el Producto
                p.agregar(producto);
                return;
            }
        }

        // No encontre la mesa.
        throw new IllegalArgumentException("Mesa no encontrada!");
    }
}
