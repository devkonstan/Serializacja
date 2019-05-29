
import java.io.*;

public class Serialize {
    public static void main(String[] args) throws IOException { //operacje IO moga zglaszac wyjatki

        Postac postac1 = new Postac(30,"Radik",new String[] {"a","b","c"});
        Postac postac2 = new Postac(30,"Radik",new String[] {"a","b","c"});
        Postac postac3 = new Postac(30,"Radik",new String[] {"a","b","c"});

        try {
            File plik = new File("MojaGra.ser");
//      strumien „połączeniowy” udostępniajacy metody pozwalające na zapisywanie bajtów!
            FileOutputStream strumienPlk = new FileOutputStream(plik);

//      strumien "łańcuchowy" wyzszego poziomu -> pozwala dzialac na obiektach (zamienia je na dane)
            ObjectOutputStream so = new ObjectOutputStream(strumienPlk);

//      obiekt znajduje sie w so i jest tam serializowany; nastepnie jest zapisywany w formie bajtowej
//      za pomoca FileOutputStream do pliku MojaGra.ser
            so.writeObject(postac1);
            so.writeObject(postac2);
            so.writeObject(postac3);
//      2 strumienie sa niezbedne, gdyz kazdy specjalizuje sie w 1 dziedzinie (paradygmat Single Responsibility)

//      Składowe statyczne nie są serializowane, a kiedy obiekt jest odtwarzany,
//      przyjmują one wartość, jaka jest w danej chwili dostępna w klasie
            so.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
