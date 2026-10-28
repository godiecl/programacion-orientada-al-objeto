/*
 * Copyright (c) 2026. Programacion Orientada el Objeto, DISC, UCN, Chile.
 */

// (c) 2026 Programacion Orientada al Objeto.
package cl.ucn.disc.poo.diccionario;

import cl.ucn.disc.poo.diccionario.domain.Diccionario;
import cl.ucn.disc.poo.diccionario.domain.DiccionarioImpl;

/**
 * Programa principal: carga el Diccionario desde un archivo y lo muestra.
 */
public final class TheMain {

    /**
     * Constructor privado: la clase no debe ser instanciada.
     */
    private TheMain() {
        // no me instanciaras!
    }

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de la linea de comandos (no se utilizan).
     */
    public static void main(final String[] args) {
        seccion("Bienvenido al Diccionario de palabras (POO, DISC, UCN, Chile)");

        // Instancio un Diccionario cargando el archivo
        final Diccionario diccionario = new DiccionarioImpl("resources/diccionario.txt");

        // muestro el diccionario
        show(diccionario);

        // elimino una palabra e informo el resultado
        String palabraEliminar = "Nema";
        seccion("Eliminando '" + palabraEliminar + "'");
        if (diccionario.eliminarPalabra(palabraEliminar)) {
            log("  [OK] Palabra eliminada: " + palabraEliminar);
        } else {
            log("  [!!] La palabra no existe en el diccionario: " + palabraEliminar);
        }
        log("");

        // muestro el diccionario actualizado
        show(diccionario);

        // inserto una palabra nueva e informo el resultado
        String palabraNueva = "Sonoro";
        seccion("Insertando '" + palabraNueva + "'");
        if (diccionario.insertarPalabra(palabraNueva, "Que suena o puede sonar.")) {
            log("  [OK] Palabra insertada: " + palabraNueva);
            log("       Significado: " + diccionario.buscarSignificado(palabraNueva));
        } else {
            log("  [!!] No se pudo insertar la palabra: " + palabraNueva);
        }
        log("");

        // listo las palabras que comienzan con una letra
        String letra = "A";
        seccion("Palabras que comienzan con '" + letra + "'");
        for (final String palabra : diccionario.getListadoPalabras(letra)) {
            log("  - " + palabra);
        }
        log("");

        // cantidad de palabras que comienzan con una letra
        seccion("Cantidad de palabras con '" + letra + "'");
        log("  " + diccionario.getCantidadDePalabras(letra) + " palabras");
        log("");

        log("Done.");
    }

    /**
     * Muestra el Diccionario agrupado por letra inicial: cada palabra
     * seguida de su significado, ajustado al ancho de la pantalla.
     *
     * @param diccionario a mostrar.
     */
    private static void show(final Diccionario diccionario) {
        seccion("Diccionario contiene " + diccionario.getCantidadDePalabras() + " palabras");

        // letra inicial del grupo que se esta mostrando
        String inicial = "";

        for (final String palabra : diccionario.getListadoPalabras()) {
            // al cambiar de letra imprimo el encabezado del grupo
            final String letra = palabra.substring(0, 1).toUpperCase();
            if (!letra.equals(inicial)) {
                inicial = letra;
                log("");
                log("  [ " + letra + " ]");
            }

            log("    " + palabra + ":");
            log("        " + diccionario.buscarSignificado(palabra));
        }
        log("");
    }


    /**
     * Muestra el titulo de una seccion entre guiones.
     *
     * @param titulo de la seccion.
     */
    private static void seccion(final String titulo) {
        // "----[" + titulo + "]" ocupa 6 caracteres mas el titulo; el resto se rellena con guiones hasta los 80
        final int relleno = Math.max(0, 80 - 6 - titulo.length());
        log("----[ " + titulo + " ]" + "-".repeat(relleno));
    }

    /**
     * Escribe un mensaje en la salida estandar.
     *
     * @param mensaje a escribir.
     */
    private static void log(final String mensaje) {
        System.out.println(mensaje);
    }

}
