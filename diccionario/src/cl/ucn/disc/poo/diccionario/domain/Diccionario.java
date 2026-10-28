/*
 * Copyright (c) 2026. Programacion Orientada el Objeto, DISC, UCN, Chile.
 */

package cl.ucn.disc.poo.diccionario.domain;

import java.util.List;

/**
 * Interface Diccionario.
 */
public interface Diccionario {

    /**
     * Método que inserta una palabra en la estructura de datos en forma ordenada.
     * La comparación ignora mayúsculas y tildes: "Efimero" y "Efímero" son la misma palabra.
     *
     * @param palabra     a insertar.
     * @param significado a insertar.
     * @return true si fue insertada, false si la palabra ya existía en el diccionario.
     */
    boolean insertarPalabra(String palabra, String significado);

    /**
     * Método que elimina una palabra de la estructura, retorna true si fue posible la eliminación y false si la palabra a eliminar no existe en el diccionario.
     *
     * @param palabra a eliminar.
     * @return true si fue eliminada.
     */
    boolean eliminarPalabra(String palabra);

    /**
     * Método que retorna el significado de la palabra, si no lo encuentra retorna null.
     *
     * @param palabra a buscar.
     * @return el significado de la palabra.
     */
    String buscarSignificado(String palabra);

    /**
     * Método que entrega un String de todas las palabras del diccionario ordenadas por orden alfabético.
     *
     * @return la lista de palabras.
     */
    List<String> getListadoPalabras();

    /**
     * Método que retorna un String de todas las palabras que comienzan con la letra,
     * sin distinguir mayúsculas ni tildes.
     *
     * @param letra del inicio de la palabra a buscar.
     * @return el listado de palabras.
     */
    List<String> getListadoPalabras(String letra);

    /**
     * Método que retorna la cantidad de palabras que comienzan con letra,
     * sin distinguir mayúsculas ni tildes.
     *
     * @param letra a buscar.
     * @return cantidad de palabras con esa letra.
     */
    int getCantidadDePalabras(String letra);

    /**
     * Metodo que retorna la cantidad total de palabras en el Diccionario.
     * @return the cantidad de palabras.
     */
    int getCantidadDePalabras();

}
