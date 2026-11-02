package cl.ucn.disc.poo.vehiculos.domain;

/**
 * Clase que representa a un auto.
 */
public final class Auto implements Motorizado, Vehiculo {

    /**
     * Valor que representa la cantidad de combustible del auto.
     */
    private int combustible;

    /**
     * Constructor de la clase Auto.
     */
    public Auto() {
        // Inicializamos el combustible del auto en 10.
        this.combustible = 10;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cargarCompustible() {
        this.combustible += 5;
        System.out.println("Cargando combustible al auto. Tanque: <" + this.combustible + ">");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCombustible() {
        return this.combustible;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void acelerar() {
        if (this.combustible == 0) {
            System.out.println("Auto sin combustible.");
            return;
        }

        if (this.combustible > 0) {
            System.out.println("El auto esta acelerando.");
            this.combustible--;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void frenar() {
        System.out.println("Auto frenando.");
    }
}
