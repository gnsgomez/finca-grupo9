package ec.edu.uagraria.suelovivo.fabrica;

import ec.edu.uagraria.suelovivo.dominio.CultivoParcela;
import ec.edu.uagraria.suelovivo.dominio.Fertilizante;
import ec.edu.uagraria.suelovivo.dominio.MuestraSuelo;
import ec.edu.uagraria.suelovivo.dominio.ProductoSuelo;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public final class FabricaProductos {

    private static final AtomicInteger CONTADOR = new AtomicInteger();

    private FabricaProductos() {
    }

    /** Switch exhaustivo sobre el enum, sin default. */
    public static ProductoSuelo crear(TipoProducto tipo, DatosProducto datos) {
        return switch (tipo) {
            case CULTIVO_PARCELA -> new CultivoParcela(generarCodigo("CP"), datos.nombre(), datos.medida());
            case MUESTRA_SUELO -> new MuestraSuelo(generarCodigo("MS"), datos.nombre(), datos.medida(),
                    datos.fecha() != null ? datos.fecha() : LocalDate.now());
            case FERTILIZANTE -> new Fertilizante(generarCodigo("FE"), datos.nombre(), datos.medida());
        };
    }

    // Si el proyecto ya tiene Trazable.generarCodigo(...), llámenlo aquí en lugar de este método.
    private static String generarCodigo(String prefijo) {
        return String.format("%s-%03d", prefijo, CONTADOR.incrementAndGet());
    }
}