package semana2.finca;

public record Animal(String codigo, String especie, double pesoKg, double precioPorKg) implements Activo {
    public Animal {
        if (pesoKg <= 0) throw new IllegalArgumentException("El peso debe ser positivo");
        if (precioPorKg < 0) throw new IllegalArgumentException("El precio no puede ser negativo");
    }
}