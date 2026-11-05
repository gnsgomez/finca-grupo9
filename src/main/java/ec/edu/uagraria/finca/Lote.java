// Clase que implementa la interfaz. Representa un lote de producción. 

public class Lote implements Trazable {

    private final String codigo;



    public Lote(String codigo) {

        this.codigo = codigo;

    }



    @Override

    public String codigo() {          // Único método obligatorio 

        return codigo;

    }

} 