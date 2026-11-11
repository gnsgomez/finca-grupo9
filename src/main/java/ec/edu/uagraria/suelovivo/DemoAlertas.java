package ec.edu.uagraria.suelovivo;

import ec.edu.uagraria.suelovivo.alertas.MotorAlertas;
import ec.edu.uagraria.suelovivo.alertas.ObservadorBitacora;
import ec.edu.uagraria.suelovivo.alertas.ObservadorConsola;
import ec.edu.uagraria.suelovivo.dominio.LecturaSuelo;
import ec.edu.uagraria.suelovivo.dominio.ProductoSuelo;
import ec.edu.uagraria.suelovivo.fabrica.DatosProducto;
import ec.edu.uagraria.suelovivo.fabrica.FabricaProductos;
import ec.edu.uagraria.suelovivo.fabrica.TipoProducto;
import ec.edu.uagraria.suelovivo.reglas.Reglas;

import java.time.LocalDate;

public class DemoAlertas {

    public static void main(String[] args) {
        System.out.println("=== Fábrica de productos ===");
        ProductoSuelo cultivo = FabricaProductos.crear(TipoProducto.CULTIVO_PARCELA, new DatosProducto("Arroz", 12.5));
        ProductoSuelo muestra = FabricaProductos.crear(TipoProducto.MUESTRA_SUELO,
                new DatosProducto("P-02", 4.8, LocalDate.of(2026, 4, 23)));
        ProductoSuelo abono = FabricaProductos.crear(TipoProducto.FERTILIZANTE, new DatosProducto("Urea", 250.0));
        System.out.println(cultivo);
        System.out.println(muestra);
        System.out.println(abono);

        System.out.println();
        System.out.println("=== Motor de alertas ===");
        MotorAlertas<LecturaSuelo> motor = new MotorAlertas<>();
        motor.agregarRegla(Reglas.phFueraRango());
        motor.agregarRegla(Reglas.muestraAntigua());
        motor.agregarRegla(Reglas.dosisExcesiva());

        ObservadorBitacora bitacora = new ObservadorBitacora();
        motor.suscribir(new ObservadorConsola());
        motor.suscribir(bitacora);

        LocalDate hoy = LocalDate.of(2026, 11, 10);
        int normales = motor.procesar(new LecturaSuelo("P-01", 6.5, hoy.minusDays(30), hoy, 120.0));
        System.out.println("Parcela P-01: " + normales + " alertas");
        int problemas = motor.procesar(new LecturaSuelo("P-02", 4.8, hoy.minusDays(200), hoy, 250.0));
        System.out.println("Parcela P-02: " + problemas + " alertas");
        System.out.println("Alertas guardadas en la bitácora: " + bitacora.registro().size());
    }
}