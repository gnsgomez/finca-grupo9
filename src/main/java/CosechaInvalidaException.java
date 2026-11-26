package semana2.finca;
public class CosechaInvalidaException extends Exception {

    private static final long serialVersionUID = 1L;

    public CosechaInvalidaException(String mensaje) {
        super(mensaje);
    }

    public CosechaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}