package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CodziennePoradySerwer {
        String[] listaPorad = {"U?ywaj mniejszych bitów", "Chod? w dopasowanych spodniach. Nie, te nie sprawiaj?, " +
                "?e wygl?dasz grubo.", "Jedno s?owo: nieodpowiednie", "Tylko dzi? - b?d? uczciwy - powiedz " +
                "swojemu szefowi, co *naprawd?* czujesz", "Mo?e chcesz zastanowi? si? nad swoj? fryzur?."};

        public void doDziela() {
        try {
            ServerSocket gniazdoSrw = new ServerSocket(55555); //aplikacja oczekuje na zadania przesylane na port 55555
            while(true) { //nieskonczona obsluga zadan nadsylanych przez klientow
                Socket gniazdo = gniazdoSrw.accept(); //wstyrzymanie dzialania programu do momentu odebrania zadania ->
                // zwrot gniazda (na razie o nieznanym porcie) umozliwiajacego komunikacje z klientem
                PrintWriter pisarz = new PrintWriter(gniazdo.getOutputStream()); //strumień PrintWriter (wykorzystujący
                // strumień wyjściowy gniazda) i przesyłający wiadomość do klienta.
                String porada = wybierzPorade();
                pisarz.println(porada);
                pisarz.close();
                System.out.println(porada);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }

    } // koniec metody
    public static void main(String[] args) {
        CodziennePoradySerwer serwer = new CodziennePoradySerwer();
        serwer.doDziela();
    }
    private String wybierzPorade() {
        int random = (int) (Math.random() * listaPorad.length);
        return listaPorad[random];
    }
}
