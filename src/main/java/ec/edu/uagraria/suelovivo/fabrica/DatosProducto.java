package ec.edu.uagraria.suelovivo.fabrica;

import java.time.LocalDate;

/**
 * Datos que recibe la fábrica.
 * CULTIVO_PARCELA: nombre = cultivo, medida = área en ha.
 * MUESTRA_SUELO: nombre = parcela, medida = pH, fecha = fecha de la muestra.
 * FERTILIZANTE: nombre = fertilizante, medida = dosis en kg/ha.
 */
public record DatosProducto(String nombre, double medida, LocalDate fecha) {

    public DatosProducto(String nombre, double medida) {
        this(nombre, medida, null);
    }
}