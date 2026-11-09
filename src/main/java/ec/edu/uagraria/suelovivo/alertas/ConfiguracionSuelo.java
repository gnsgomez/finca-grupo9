public enum ConfiguracionSuelo {
    INSTANCIA;

    private static final double PH_MIN_DEFECTO = 5.5;
    private static final double PH_MAX_DEFECTO = 7.5;
    private static final int DIAS_MAX_DEFECTO = 180;
    private static final double DOSIS_MAX_DEFECTO = 200.0;

    private double phMinimo = PH_MIN_DEFECTO;
    private double phMaximo = PH_MAX_DEFECTO;
    private int diasMaximoAntiguedad = DIAS_MAX_DEFECTO;
    private double dosisMaxima = DOSIS_MAX_DEFECTO;

    public double phMinimo() { return phMinimo; }
    public double phMaximo() { return phMaximo; }
    public int diasMaximoAntiguedad() { return diasMaximoAntiguedad; }
    public double dosisMaxima() { return dosisMaxima; }

    public void cambiarPhMinimo(double valor) { this.phMinimo = valor; }
    public void cambiarPhMaximo(double valor) { this.phMaximo = valor; }
    public void cambiarDiasMaximoAntiguedad(int valor) { this.diasMaximoAntiguedad = valor; }
    public void cambiarDosisMaxima(double valor) { this.dosisMaxima = valor; }

    public void restablecer() {
        phMinimo = PH_MIN_DEFECTO;
        phMaximo = PH_MAX_DEFECTO;
        diasMaximoAntiguedad = DIAS_MAX_DEFECTO;
        dosisMaxima = DOSIS_MAX_DEFECTO;
    }
}