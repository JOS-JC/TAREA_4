import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Baraja {
    private List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(palo, valor));
            }
        }
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        return cartas.remove(cartas.size() - 1);
    }

    public boolean hayCartas() {
        return !cartas.isEmpty();
    }
}
