package cl.ucn.disc.poo.vehiculos;

import cl.ucn.disc.poo.vehiculos.domain.Auto;
import cl.ucn.disc.poo.vehiculos.domain.Bicicleta;
import cl.ucn.disc.poo.vehiculos.domain.Motorizado;
import cl.ucn.disc.poo.vehiculos.domain.Vehiculo;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main.
 */
public final class TheMain {

    /**
     * The main method.
     */
    public static void main(String[] args) {

        // Crear un auto.
        Auto auto = new Auto();

        // Crear una bicicleta.
        Bicicleta bicicleta = new Bicicleta();

        // Crear una lista de vehículos.
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto);
        vehiculos.add(bicicleta);
        // se puede reemplazar por List.of(auto, bicicleta):
        // List<Vehiculo> vehiculos = List.of(auto, bicicleta);

        // Crear una lista de vehiculos motorizados.
        List<Motorizado> motorizados = new ArrayList<>();
        motorizados.add(auto);
        // se puede reemplazar por List.of(auto):
        // List<Motorizado> motorizados = List.of(auto);

        // Probar los vehiculos.
        probarVehiculos(vehiculos);

        // Revisar el combustible de los vehiculos motorizados.
        revisarCombustible(motorizados);

        // Contar los vehiculos motorizados con combustible.
        int cantidad = contarConCombustible(motorizados);
        System.out.println("Cantidad de vehiculos con combustible: " + cantidad);


    }

    /**
     * Metodo que permite probar los vehiculos.
     *
     * @param vehiculos a probar.
     */
    private static void probarVehiculos(List<Vehiculo> vehiculos) {
        // iterar sobre la lista de vehiculos.
        for (Vehiculo vehiculo : vehiculos) {
            // acelerar ..
            vehiculo.acelerar();
            // .. y frenar.
            vehiculo.frenar();
        }
    }

    /**
     * Metodo que permite revisar el combustible de los vehiculos motorizados.
     *
     * @param motorizados a revisar.
     */
    private static void revisarCombustible(List<Motorizado> motorizados) {
        // iterar sobre la lista de vehiculos.
        for (Motorizado motorizado : motorizados) {
            System.out.println("Combustible: " + motorizado.getCombustible());
        }
    }

    /**
     * Metodo que permite contar los vehiculos motorizados con combustible.
     *
     * @param motorizados a contar.
     * @return la cantidad de vehiculos con combustible.
     */
    private static int contarConCombustible(List<Motorizado> motorizados) {
        // contador de los motorizados con combustible.
        int contador = 0;

        // iterar sobre la lista de vehiculos.
        for (Motorizado motorizado : motorizados) {
            // si el vehiculo tiene combustible, incrementar el contador.
            if (motorizado.getCombustible() > 0) {
                contador++;
            }
        }
        // retornar el contador.
        return contador;
    }

}
