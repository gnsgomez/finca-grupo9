package semana2.finca;

public class PruebaValidacionesGonzalez {
    public static void main(String[] args) {
        probar("Producto con unidades negativas",
                () -> new Producto("PR-X", "Prueba", 10.0, -1));
        probar("Cultivo con hectáreas en cero",
                () -> new Cultivo("CU-X", "Prueba", 0, 100.0));
        probar("Animal con peso negativo",
                () -> new Animal("AN-X", "Prueba", -5.0, 1.5));
    }

    private static void probar(String descripcion, Runnable creacion) {
        try {
            creacion.run();
            System.out.println("FALLO: " + descripcion + " no lanzó excepción");
        } catch (IllegalArgumentException e) {
            System.out.println("OK: " + descripcion + " -> " + e.getMessage());
        }
    }
}