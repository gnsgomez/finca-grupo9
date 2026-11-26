package repo;

public record Cultivo(Integer id, String nombre, double hectareas, double rendimientoTmHa)
        implements Identificable<Integer> {

    @Override
    public Integer getId() {
        return id;
    }

    public double produccionTm() {
        return hectareas * rendimientoTmHa;
    }
}