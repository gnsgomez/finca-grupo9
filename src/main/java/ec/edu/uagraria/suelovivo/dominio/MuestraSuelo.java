package ec.edu.uagraria.suelovivo.dominio;

import java.time.LocalDate;

public record MuestraSuelo(String codigo, String parcela, double ph, LocalDate fecha) implements ProductoSuelo {
}