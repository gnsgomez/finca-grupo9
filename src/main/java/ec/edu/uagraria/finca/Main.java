public class Main {

    public static void main(String[] args) {

        // Método static: se llama por el nombre de la interfaz

        String codigo = Trazable.generarCodigo("cacao", 7);



        // Método default: Lote lo hereda sin escribirlo

        Lote lote = new Lote(codigo);

        System.out.println("Código:   " + lote.codigo());

        System.out.println("Etiqueta: " + lote.etiquetaTrazabilidad());



        // Validación del método static (lanza IllegalArgumentException)

        try {

            Trazable.generarCodigo("", 1);

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        }

    }

}
