package repo;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T extends Identificable<ID>, ID> {
    void guardar(T entidad);
    Optional<T> buscarPorId(ID id);
    List<T> listarTodos();
    boolean eliminar(ID id);
    int contar();
}