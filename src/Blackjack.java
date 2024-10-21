import java.util.Scanner;

class Blackjack {
    private Baraja baraja;
    private Jugador jugador;
    private Jugador dealer;

    public Blackjack() {
        baraja = new Baraja();
        jugador = new Jugador("Jugador");
        dealer = new Jugador("Dealer");
    }

    public void jugar() {
        // Repartir cartas iniciales
        jugador.agregarCarta(baraja.sacarCarta());
        dealer.agregarCarta(baraja.sacarCarta());
        jugador.agregarCarta(baraja.sacarCarta());
        dealer.agregarCarta(baraja.sacarCarta());

        // Mostrar manos iniciales
        jugador.mostrarMano();
        System.out.println("Dealer tiene: " + dealer.getNombre() + " muestra: " + dealer.calcularPuntuacion() + " (una carta oculta)");

        // Turno del jugador
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("¿Quieres (H)it o (S)tand?");
            String decision = scanner.nextLine().toUpperCase();
            if (decision.equals("H")) {
                jugador.agregarCarta(baraja.sacarCarta());
                jugador.mostrarMano();
                if (jugador.estaBusted()) {
                    System.out.println("Te has pasado de 21. ¡Has perdido!");
                    return;
                }
            } else if (decision.equals("S")) {
                break;
            }
        }

        // Turno del dealer
        while (dealer.calcularPuntuacion() < 17) {
            dealer.agregarCarta(baraja.sacarCarta());
        }
        dealer.mostrarMano();

        // Resultados
        determinarGanador();
    }

    private void determinarGanador() {
        int puntuacionJugador = jugador.calcularPuntuacion();
        int puntuacionDealer = dealer.calcularPuntuacion();

        System.out.println("Puntuación del Jugador: " + puntuacionJugador);
        System.out.println("Puntuación del Dealer: " + puntuacionDealer);

        if (dealer.estaBusted()) {
            System.out.println("¡El dealer se ha pasado! ¡Has ganado!");
        } else if (puntuacionJugador > puntuacionDealer) {
            System.out.println("¡Has ganado!");
        } else if (puntuacionJugador < puntuacionDealer) {
            System.out.println("¡El dealer gana!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }
}
