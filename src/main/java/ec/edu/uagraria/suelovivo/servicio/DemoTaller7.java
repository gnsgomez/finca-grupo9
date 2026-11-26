
package ec.edu.uagraria.suelovivo.servicio;

public class DemoTaller7 {

    public static void main(String[] args) {

        Inventario inv = new Inventario();

        // Registrar cinco productos del tema SueloVivo
        inv.registrar(new ItemInventario(
                "CUL-0001", "CultivoParcela",
                "Maiz parcela norte", 250.0));

        inv.registrar(new ItemInventario(
                "MUE-0001", "MuestraSuelo",
                "Muestra lote 1", 120.0));

        inv.registrar(new ItemInventario(
                "FER-0001", "Fertilizante",
                "Urea 50 kg", 200.0));

        inv.registrar(new ItemInventario(
                "MUE-0002", "MuestraSuelo",
                "Muestra lote 2", 90.0));

        // Código repetido para demostrar el Set
        inv.registrar(new ItemInventario(
                "MUE-0001", "MuestraSuelo",
                "Muestra lote 1 reingreso", 30.0));

        System.out.println("Registros (List): "
                + inv.registros().size());

        System.out.println("Codigos unicos (Set): "
                + inv.codigosUnicos());

        System.out.println("Total por tipo (Map): "
                + inv.totalPorTipo());

        System.out.println("Ordenados por cantidad (Comparator):");

        inv.ordenadosPorCantidad().forEach(i ->
                System.out.printf(" %-9s %-17s %7.1f%n",
                        i.codigo(), i.tipo(), i.cantidad()));

        // Cola de despacho
        inv.ordenadosPorCantidad().forEach(inv::encolarDespacho);

        System.out.println("Despacho (Deque): "
                + inv.despacharSiguiente()
                .orElseThrow().codigo()
                + " | pendientes: "
                + inv.pendientesDespacho());
    }
}
