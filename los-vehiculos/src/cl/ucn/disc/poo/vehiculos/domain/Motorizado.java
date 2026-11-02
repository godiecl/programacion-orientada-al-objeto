package cl.ucn.disc.poo.vehiculos.domain;

/**
 * Interface que representa a un vehiculo motorizado.
 */
public interface Motorizado {

    /**
     * Metodo que permite cargar combustible al vehiculo.
     */
    void cargarCompustible();

    /**
     * Metodo que permite obtener la cantidad de combustible del vehiculo.
     *
     * @return la cantidad de combustible.
     */
    int getCombustible();

}
