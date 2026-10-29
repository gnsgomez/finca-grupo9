package semana2.finca;

public record Cultivo(String codigo, String nombre, double hectareas, double costoPorHectarea) implements Activo {
    public Cultivo {
        if (hectareas <= 0) throw new IllegalArgumentException("Hectareas debe ser positiva");
        if (costoPorHectarea < 0) throw new IllegalArgumentException("Costo no puede ser negativo");
    }
}