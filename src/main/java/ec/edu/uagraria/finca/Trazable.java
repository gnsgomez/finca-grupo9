public interface Trazable {



    // Sin cuerpo: cada clase debe escribirlo.

    String codigo();



    // DEFAULT: cuerpo ya escrito, lo heredan todas.

    default String etiquetaTrazabilidad() {

        return "UAE-" + codigo().toUpperCase();

    }



    // STATIC: pertenece a la interfaz, no a los objetos.

    static String generarCodigo(String prefijo, int secuencia) {

        if (prefijo == null || prefijo.isBlank()) {

            throw new IllegalArgumentException(

                    "El prefijo no puede estar vacio");

        }

        return "%s-%04d".formatted(prefijo.toUpperCase(), secuencia);

    }

}
