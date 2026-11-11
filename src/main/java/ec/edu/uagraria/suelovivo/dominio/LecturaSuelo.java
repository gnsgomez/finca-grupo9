package ec.edu.uagraria.suelovivo.dominio;

import java.time.LocalDate;

/** Entrada del motor de alertas: los datos de una parcela en un momento dado. */
public record LecturaSuelo(String parcela, double ph, LocalDate fechaMuestra,
                           LocalDate fechaLectura, double dosisKgHa) {
}