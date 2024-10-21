class Carta {
    private String palo;
    private String valor;
    private int valorNumerico;

    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
        this.valorNumerico = calcularValorNumerico(valor);
    }

    private int calcularValorNumerico(String valor) {
        switch (valor) {
            case "A":
                return 11; // El valor del As puede ser 1 o 11, se maneja en la lógica del jugador
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(valor);
        }
    }

    public String getPalo() {
        return palo;
    }

    public String getValor() {
        return valor;
    }

    public int getValorNumerico() {
        return valorNumerico;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
