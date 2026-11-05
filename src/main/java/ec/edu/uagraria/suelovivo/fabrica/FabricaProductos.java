package ec.edu.uagraria.suelovivo.fabrica;

public final class FabricaProductos {

    private FabricaProductos() {}

    // Por ahora devuelve String para que te compile, luego lo cambias a tus records
    public static String crear(TipoProducto tipo) {
        return switch (tipo) {
            case CULTIVO_PARCELA -> "Cultivo creado";
            case MUESTRA_SUELO -> "Muestra creada";
            case FERTILIZANTE -> "Fertilizante creado";
        };
    }
}