import java.io.*;

public class Deserialize {
    public static void main(String[] args) throws IOException { //operacje IO moga zglaszac wyjatki

        Postac postac1 = new Postac(30,"Radik",new String[] {"a","b","c"});
        Postac postac2 = new Postac(30,"Radik",new String[] {"a","b","c"});
        Postac postac3 = new Postac(30,"Radik",new String[] {"a","b","c"});

        try {
            File plik = new File("MojaGra.ser");
            FileInputStream strumienPlk = new FileInputStream(plik);
            ObjectInputStream os = new ObjectInputStream(strumienPlk);


            Object obj1 = os.readObject();
            Object obj2 = os.readObject();
            Object obj3 = os.readObject();

//      Każde wywołanie metody readObject() powoduje odczytanie kolejnego obiektu ze strumienia.
//      A zatem obiekty zostaną odtworzone w takiej samej kolejności, w jakiej je zapisałeś.
//      Jeśli spróbujesz odczytać więcej obiektów, niż zapisałeś, zostanie zgłoszony wyjątek.

            Postac elf = (Postac) obj1;
            Postac troll = (Postac) obj2;
            Postac gnom = (Postac) obj3;
//      Wartość zwracana przez metodę readObject() jest typu Object
//      a zatem musimy rzutować obiekty na taki typ, jakiego faktycznie są.

            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
