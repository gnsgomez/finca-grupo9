package ec.edu.uagraria.suelovivo.reglas;

import ec.edu.uagraria.suelovivo.alertas.Alerta;
import ec.edu.uagraria.suelovivo.alertas.ConfiguracionSuelo;
import ec.edu.uagraria.suelovivo.alertas.ReglaAlerta;
import ec.edu.uagraria.suelovivo.alertas.TipoAlerta;
import ec.edu.uagraria.suelovivo.dominio.LecturaSuelo;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

/** Las tres alertas de SueloVivo. Los umbrales salen de ConfiguracionSuelo. */
public final class Reglas {

    private Reglas() {
    }

    public static ReglaAlerta<LecturaSuelo> phFueraRango() {
        return lectura -> {
            ConfiguracionSuelo cfg = ConfiguracionSuelo.INSTANCIA;
            if (lectura.ph() < cfg.phMinimo() || lectura.ph() > cfg.phMaximo()) {
                return Optional.of(new Alerta(TipoAlerta.PH_FUERA_RANGO,
                        "pH " + lectura.ph() + " fuera del rango " + cfg.phMinimo() + "-" + cfg.phMaximo()
                                + " en " + lectura.parcela()));
            }
            return Optional.empty();
        };
    }

    public static ReglaAlerta<LecturaSuelo> muestraAntigua() {
        return lectura -> {
            long dias = ChronoUnit.DAYS.between(lectura.fechaMuestra(), lectura.fechaLectura());
            if (dias > ConfiguracionSuelo.INSTANCIA.diasMaximoAntiguedad()) {
                return Optional.of(new Alerta(TipoAlerta.MUESTRA_ANTIGUA,
                        "Muestra de " + lectura.parcela() + " tiene " + dias + " días (máximo "
                                + ConfiguracionSuelo.INSTANCIA.diasMaximoAntiguedad() + ")"));
            }
            return Optional.empty();
        };
    }

    public static ReglaAlerta<LecturaSuelo> dosisExcesiva() {
        return lectura -> {
            if (lectura.dosisKgHa() > ConfiguracionSuelo.INSTANCIA.dosisMaxima()) {
                return Optional.of(new Alerta(TipoAlerta.DOSIS_EXCESIVA,
                        "Dosis " + lectura.dosisKgHa() + " kg/ha supera el máximo "
                                + ConfiguracionSuelo.INSTANCIA.dosisMaxima() + " en " + lectura.parcela()));
            }
            return Optional.empty();
        };
    }
}