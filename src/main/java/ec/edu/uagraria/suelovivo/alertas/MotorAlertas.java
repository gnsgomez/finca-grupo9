package ec.edu.uagraria.suelovivo.alertas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MotorAlertas<T> {

    private final List<ReglaAlerta<T>> reglas = new ArrayList<>();
    private final List<ObservadorAlertas> observadores = new ArrayList<>();

    public void agregarRegla(ReglaAlerta<T> regla) {
        reglas.add(regla);
    }

    public void suscribir(ObservadorAlertas observador) {
        observadores.add(observador);
    }

    public int procesar(T entrada) {
        int publicadas = 0;
        for (ReglaAlerta<T> regla : reglas) {
            Optional<Alerta> alerta = regla.evaluar(entrada);
            if (alerta.isPresent()) {
                observadores.forEach(o -> o.notificar(alerta.get()));
                publicadas++;
            }
        }
        return publicadas;
    }
}