import java.io.*;

public class Archiwizator {
    public static void main(String[] args) {
        Postac postac1 = new Postac(50, "Elf", new String[] {"?uk", "miecz", "py?"});
        Postac postac2 = new Postac(200, "Trol", new String[] {"pi??ci", "wielki topór"});
        Postac postac3 = new Postac(120, "Magik", new String[] {"czary", "niewidzialno??"});
// tu wykonujemy jakie? operacje, które mog? zmienia? stan postaci,
// a nast?pnie zapisujemy te obiekty
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Gra.ser"));
            os.writeObject(postac1);
            os.writeObject(postac2);
            os.writeObject(postac3);
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        postac1 = null;
        postac2 = null;
        postac3 = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Gra.ser"));
            Postac p1N = (Postac) is.readObject();
            Postac p2N = (Postac) is.readObject();
            Postac p3N = (Postac) is.readObject();
            System.out.println("Typ postaci 1.:" + p1N.getTyp());
            System.out.println("Typ postaci 2.:" + p2N.getTyp());
            System.out.println("Typ postaci 3.:" + p3N.getTyp());
        } catch (Exception ex) {
            ex.printStackTrace ();
        }
    }
}
