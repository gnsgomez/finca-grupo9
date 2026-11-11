package ec.edu.uagraria.suelovivo.alertas;

public class ObservadorConsola implements ObservadorAlertas {

    @Override
    public void notificar(Alerta alerta) {
        System.out.println("[ALERTA " + alerta.tipo() + "] " + alerta.mensaje());
    }
}