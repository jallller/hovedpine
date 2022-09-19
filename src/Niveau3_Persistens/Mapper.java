package Niveau3_Persistens;


import Niveau2_Logik.TerminalInput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    static void opdaterLåner() {
        udskrivLånere();
        String sql = "update  låner set lånerNavn = ? where idLåner = ?";

        try (Connection con = ConnectionConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            String kundeNavn = TerminalInput.getString("angiv et nyt navn");
            ps.setString(1, kundeNavn);
            ps.setInt(2, TerminalInput.getInt("skriv et tal"));


            int res = ps.executeUpdate();
            if (res > 0) {

                System.out.println("Låneren med navnet " + "\"" + kundeNavn + "\"" + " er nu blevet opdateret");
            } else {
                System.out.println("en låner med det nr fandtes ikke i listen ");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        udskrivLånere();
    }

    static void sletLåner() {
        udskrivLånere();
        String sql = "delete from låner where lånerNavn = ?";

        try (Connection con = ConnectionConfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);) {

            String kundeNavn = TerminalInput.getString("skriv navnet på den låner du vil slette");
            ps.setString(1, kundeNavn);


            int res = ps.executeUpdate();       //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            if (res > 0) {

                System.out.println("Låneren med navnet " + "\"" + kundeNavn + "\"" + " er nu blevet slettet");
            } else {
                System.out.println("En låner med navnet " + "\"" + kundeNavn + "\"" + " fandtes ikke i listen");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        udskrivLånere();
    }

    static void opretLåner() {
        String sql = "INSERT INTO Låner (lånerNavn) VALUES (?)";

        try (Connection con = ConnectionConfig.getConnection();  // får en connection
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, TerminalInput.getString("skriv et navn"));

            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            System.out.println("vi er nået til række: " + ids.getInt(1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void udskrivLånere() {
        List<String> lånerListe = new ArrayList<>();

        String sql1 = "select * from låner ";

        try (Connection connection = ConnectionConfig.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql1)) {           // https://en.wikipedia.org/wiki/Prepared_statement

            ResultSet resultSet = ps.executeQuery();   //https://javaconceptoftheday.com/difference-between-executequery-executeupdate-execute-in-jdbc/

            while (resultSet.next()) {
                int id = resultSet.getInt("idLåner");
                String navn = resultSet.getString("lånerNavn");

                lånerListe.add(id + " : " + navn);

                for (String s : lånerListe) {
                    System.out.println(s);

                }
                for (String s : lånerListe) {
                    System.out.println(s);
                }
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
