package ec.edu.uagraria.suelovivo.alertas;

import java.util.Optional;

@FunctionalInterface
public interface ReglaAlerta<T> {
    Optional<Alerta> evaluar(T entrada);
}