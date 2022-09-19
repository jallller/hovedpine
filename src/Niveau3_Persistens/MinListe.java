package Niveau3_Persistens;

import Niveau2_Logik.TerminalInput;

import java.util.LinkedList;
import java.util.List;

public class MinListe {
    List<String> liste = new LinkedList<>();

    public MinListe() {
        liste.add("palle");
        liste.add("ulla");
        liste.add("lone");
        liste.add("bo");
    }


    protected void opretLåner(){
        liste.add(TerminalInput.getString("Skriv et navn"));
    }
    protected void opdaterLåner(){
        Mapper.opdaterLåner();
    }
    protected void sletLåner(){
        liste.remove(TerminalInput.getString("skriv et navn"));
    }

    protected void udskrivLånere(){
        for (String s : liste) {
            System.out.println(s);
        }
    }

}
