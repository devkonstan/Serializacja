import java.io.Serializable;

public class Postac implements Serializable {
    int moc;
    String typ;
    String [] bronie;

    public Postac(int moc, String typ, String[] bronie) {
        this.moc = moc;
        this.typ = typ;
        this.bronie = bronie;
    }
//    Jeśli dana składowa nie może (lub nie powinna) być zapisywana, oznacz ją słowem kluczowym "transient".

//    Serializowac nie mozna połączen sieciowych, wątkow czy też obiektow plików. Wszystkie te obiekty
//    są zależne od (i unikalne dla) konkretnego „wykonania” i związanej z nim sytuacji. Innymi słowy,
//    obiekty te tworzone są w sposób, który jest unikalny dla konkretnego uruchomienia programu, na konkretnej
//    platformie systemowej i przy użyciu konkretnej wirtualnej maszyny Javy.
//    Brak serializacji -> na przykład z powodów bezpieczeństwa, możesz nie życzyć sobie zapisywania obiektu hasła.
    private void wezBron() {

    }

    private void uzyjBroni() {

    }

    private void zwiekszMoc() {

    }

    public String getTyp() {
        return typ;
    }
}
