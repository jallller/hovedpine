package Niveau3_Persistens;

public class Facade {
    static MinListe minListe = new MinListe();

    public static void opretLåner() {

        minListe.opretLåner();
    }

    public static void opdaterLåner() {
        minListe.opdaterLåner();
    }

    public static void sletLåner() {
        minListe.sletLåner();
    }

    public static void udskrivLånere() {
        minListe.udskrivLånere();
    }
}
