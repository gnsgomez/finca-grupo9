package ec.edu.uagraria.suelovivo.dominio;

/** Jerarquía sellada: solo estos tres productos existen en SueloVivo. */
public sealed interface ProductoSuelo permits CultivoParcela, MuestraSuelo, Fertilizante {
    String codigo();
}