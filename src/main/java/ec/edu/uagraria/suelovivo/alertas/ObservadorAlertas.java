package ec.edu.uagraria.suelovivo.alertas;

@FunctionalInterface
public interface ObservadorAlertas {
    void notificar(Alerta alerta);
}