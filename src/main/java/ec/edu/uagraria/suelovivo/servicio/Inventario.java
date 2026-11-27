
package ec.edu.uagraria.suelovivo.servicio;

import java.util.*;

/**
 * Inventario del proyecto SueloVivo
 * utilizando Java Collections Framework.
 */
public class Inventario {

    // 1. LIST: registros en orden de llegada
    private final List<ItemInventario> registros =
            new ArrayList<>();

    // 5. DEQUE: cola de despacho FIFO
    private final Deque<ItemInventario> colaDespacho =
            new ArrayDeque<>();

    // Registrar un producto
    public void registrar(ItemInventario item) {
        registros.add(Objects.requireNonNull(item));
    }

    // 2. SET: códigos únicos ordenados
    public Set<String> codigosUnicos() {
        Set<String> codigos = new TreeSet<>();

        for (ItemInventario i : registros) {
            codigos.add(i.codigo());
        }

        return codigos;
    }

    // 3. MAP: total de cantidad por tipo
    public Map<String, Double> totalPorTipo() {
        Map<String, Double> totales = new TreeMap<>();

        for (ItemInventario i : registros) {
            totales.merge(
                    i.tipo(),
                    i.cantidad(),
                    Double::sum
            );
        }

        return totales;
    }

    // 4. COMPARATOR: ordenar de mayor a menor cantidad
    public List<ItemInventario> ordenadosPorCantidad() {
        List<ItemInventario> copia =
                new ArrayList<>(registros);

        copia.sort(
                Comparator.comparingDouble(
                                ItemInventario::cantidad)
                        .reversed()
                        .thenComparing(ItemInventario::codigo)
        );

        return copia;
    }

    // 5. DEQUE: agregar a la cola de despacho
    public void encolarDespacho(ItemInventario item) {
        colaDespacho.offerLast(item);
    }

    // Despachar el siguiente producto
    public Optional<ItemInventario> despacharSiguiente() {
        return Optional.ofNullable(
                colaDespacho.pollFirst());
    }

    // Cantidad de productos pendientes
    public int pendientesDespacho() {
        return colaDespacho.size();
    }

    // Devolver los registros como una lista inmutable
    public List<ItemInventario> registros() {
        return List.copyOf(registros);
    }
}
