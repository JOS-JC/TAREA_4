import java.util.ArrayList;
import java.util.List;

class Jugador {
    private List<Carta> mano;
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        mano.add(carta);
    }

    public int calcularPuntuacion() {
        int total = 0;
        int ases = 0;

        for (Carta carta : mano) {
            total += carta.getValorNumerico();
            if (carta.getValor().equals("A")) {
                ases++;
            }
        }

        while (total > 21 && ases > 0) {
            total -= 10; // Convertir un As de 11 a 1
            ases--;
        }

        return total;
    }

    public void mostrarMano() {
        System.out.println(nombre + " tiene: " + mano);
    }

    public boolean tieneBlackjack() {
        return mano.size() == 2 && calcularPuntuacion() == 21;
    }

    public boolean estaBusted() {
        return calcularPuntuacion() > 21;
    }

    public String getNombre() {
        return nombre;
    }
}
