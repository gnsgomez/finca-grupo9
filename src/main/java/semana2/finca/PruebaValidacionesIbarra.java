package semana2.finca;

public class PruebaValidacionesIbarra {
    public static void main(String[] args) {
        probar("Producto con unidades negativas",
                () -> new Producto("PR-I", "Arroz", 10.0, -2));

        probar("Cultivo con hectareas negativas",
                () -> new Cultivo("CU-I", "Arroz", -1.0, 100.0));

        probar("Animal con peso cero",
                () -> new Animal("AN-I", "Bovino", 0.0, 1.5));
    }

    private static void probar(String descripcion, Runnable creacion) {
        try {
            creacion.run();
            throw new AssertionError("FALLO: " + descripcion
                    + " no lanzo excepcion");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: " + descripcion + " -> " + e.getMessage());
        }
    }
}