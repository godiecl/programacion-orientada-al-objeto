/*
 * Copyright (c) 2026. Programacion Orientada el Objeto, DISC, UCN, Chile.
 */

// (c) 2026 Programacion Orientada al Objeto.
package cl.ucn.disc.poo.diccionario.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Clase utilitaria utilizada para leer archivo.
 */
public final class Archive {

    /**
     * Constructor privado para enviar el new!
     */
    private Archive() {
        // no me instanciaras!
    }

    /**
     * Lee todas las lineas de un archivo.
     *
     * @param filename nombre del archivo a leer.
     * @return el List de filas.
     */
    public static List<String> readLines(final String filename) {

        // get the path of the file
        Path path = Paths.get(filename);

        try {
            // Read and return all the lines
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
