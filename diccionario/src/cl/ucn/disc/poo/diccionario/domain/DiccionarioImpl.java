/*
 * Copyright (c) 2026. Programacion Orientada el Objeto, DISC, UCN, Chile.
 */

package cl.ucn.disc.poo.diccionario.domain;

import cl.ucn.disc.poo.diccionario.utils.Archive;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Implementacion de un Diccionario.
 */
public final class DiccionarioImpl implements Diccionario {

    /**
     * El listado de Terminos:
     * - El atributo es final porque la lista de Terminos no cambia.
     * - Se instancia inmediatamente vía new.
     */
    private final List<Termino> terminos = new ArrayList<>();

    /**
     * Comparador de palabras en español: ignora mayúsculas y tildes, y ordena
     * la ñ después de la n.
     */
    private final Collator collator = Collator.getInstance(Locale.forLanguageTag("es"));

    /**
     * Constructor: llama al cargar archivo en su instanciacion.
     */
    public DiccionarioImpl(String archivo) {
        // solo diferencio letras base: "a", "A" y "á" son iguales.
        this.collator.setStrength(Collator.PRIMARY);

        // El constructor llama el metodo cargar archivo.
        this.cargarArchivo(archivo);
    }

    /**
     * Lee el nombreArchivo y lo carga en el Diccionario.
     *
     * @param nombreArchivo a cargar.
     */
    public void cargarArchivo(String nombreArchivo) {

        // cargo las lineas del diccionario en
        // la lista lineas.
        List<String> lineas = Archive.readLines(nombreArchivo);

        // itero sobre la lista
        for (String linea : lineas) {
            // Ignoro las lineas vacias.
            if (linea.isBlank()) {
                continue;
            }

            // Desde la linea separo la primera palabra de su significado.
            String[] partes = linea.trim().split("\\s+", 2);

            // Una linea con una sola palabra no tiene significado: la notifico y sigo con la siguiente.
            if (partes.length < 2) {
                System.err.println("Linea sin significado, se ignora: " + linea);
                continue;
            }

            // Al separar la siguiente linea:
            // Paleografía Disciplina cuyo objeto es el estudio y la interpretación de las escrituras antiguas.

            // partes[0] --> Paleografía
            String palabra = partes[0];

            // partes[1] --> Disciplina cuyo objeto es el estudio y la interpretación de las escrituras antiguas.
            String significado = partes[1];

            // Lo agrego al diccionario, si hay un error lo notifico
            if (!this.insertarPalabra(palabra, significado)) {
                System.err.println("La palabra ya existe, se ignora: " + palabra);
            }
        }

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean insertarPalabra(String palabra, String significado) {
        // validaciones
        if (palabra == null || significado == null) {
            throw new IllegalArgumentException("Palabra o significado fue null!");
        }

        if (palabra.isBlank() || significado.isBlank()) {
            throw new IllegalArgumentException("Palabra o significado esta vacio!");
        }

        // si la palabra ya existe no la inserto
        if (this.buscarPosicion(palabra) >= 0) {
            return false;
        }

        // construyo un termino
        Termino termino = new Termino(palabra, significado);

        // lo inserto en el arreglo
        this.terminos.add(termino);

        // ordenar el arreglo.
        this.terminos.sort((a, b) -> this.collator.compare(a.getPalabra(), b.getPalabra()));

        return true;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean eliminarPalabra(String palabra) {
        // validaciones
        if (palabra == null || palabra.isBlank()) {
            throw new IllegalArgumentException("No se puede eliminar palabra vacia");
        }

        // buscar la posicion de la palabra
        int posicion = this.buscarPosicion(palabra);

        // .. no encontre la palabra a eliminar en el diccionario.
        if (posicion < 0) {
            return false;
        }

        // Encontre la palabra en la posicion -> eliminar esa posicion
        this.terminos.remove(posicion);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String buscarSignificado(String palabra) {
        // busco la posicion de la palabra
        int posicion = this.buscarPosicion(palabra);

        // no encontre la palabra -> null (segun el contrato de Diccionario)
        if (posicion < 0) {
            return null;
        }

        // retorno su significado
        return this.terminos.get(posicion).getSignificado();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getListadoPalabras() {
        // listado donde estaran todas las palabras
        List<String> palabras = new ArrayList<>();

        // recorro todo el diccionario
        for (Termino t : this.terminos) {
            // agrego la palabra del termino a al lista.
            palabras.add(t.getPalabra());
        }

        // aca estan todas las palabras!
        return palabras;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getListadoPalabras(String letra) {
        // validaciones
        if (letra == null || letra.isBlank()) {
            throw new IllegalArgumentException("La letra no puede ser vacia");
        }

        // listado donde estaran todas las palabras
        List<String> palabras = new ArrayList<>();

        // recorro todo el diccionario
        for (Termino t : this.terminos) {
            // agrego la palabra del termino a al lista
            // si y solo si comienza con la letra (sin importar mayuscula o tilde)
            if (this.comienzaCon(t.getPalabra(), letra)) {
                palabras.add(t.getPalabra());
            }
        }

        // aca estan todas las palabras que parten con letra
        return palabras;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCantidadDePalabras(String letra) {
        // las palabras que parten con letra
        return this.getListadoPalabras(letra).size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCantidadDePalabras() {
        return this.terminos.size();
    }

    /**
     * Busca la posicion de una palabra, ignorando mayusculas y tildes.
     *
     * @param palabra a buscar.
     * @return la posicion de la palabra o -1 si no existe.
     */
    private int buscarPosicion(String palabra) {
        for (int i = 0; i < this.terminos.size(); i++) {
            if (this.collator.equals(this.terminos.get(i).getPalabra(), palabra)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Indica si la palabra comienza con el prefijo, ignorando mayusculas y tildes.
     *
     * @param palabra a revisar.
     * @param prefijo con el que debe comenzar.
     * @return true si la palabra comienza con el prefijo.
     */
    private boolean comienzaCon(String palabra, String prefijo) {
        // una palabra mas corta que el prefijo no puede comenzar con el
        if (palabra.length() < prefijo.length()) {
            return false;
        }
        return this.collator.equals(palabra.substring(0, prefijo.length()), prefijo);
    }

}
