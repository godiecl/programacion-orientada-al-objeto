/*
 * Copyright (c) 2026. Programacion Orientada el Objeto, DISC, UCN, Chile.
 */

package cl.ucn.disc.poo.diccionario.domain;

public final class Termino {

    private String palabra;

    private String significado;

    public Termino(String palabra, String significado) {
        this.palabra = palabra;
        this.significado = significado;
    }

    public String getPalabra() {
        return this.palabra;
    }

    public String getSignificado() {
        return this.significado;
    }
}
