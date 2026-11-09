import java.util.ArrayList;
import java.util.List;

public class ObservadorBitacora implements ObservadorAlertas {

    private final List<Alerta> registro = new ArrayList<>();

    @Override
    public void notificar(Alerta alerta) {
        registro.add(alerta);
    }

    public List<Alerta> registro() {
        return List.copyOf(registro);
    }
}