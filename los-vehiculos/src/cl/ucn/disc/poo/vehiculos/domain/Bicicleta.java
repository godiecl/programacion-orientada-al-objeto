package cl.ucn.disc.poo.vehiculos.domain;

/**
 * Clase que representa a una bicicleta.
 */
public final class Bicicleta implements Vehiculo {

    /**
     * Constructor de la clase Bicicleta.
     */
    public Bicicleta() {
        // nothing here
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void acelerar() {
        System.out.println("La bicicleta esta acelerando.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void frenar() {
        System.out.println("La bicicleta esta frenando.");
    }

}
