package Niveau3_Persistens;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class ConnectionConfig {
    public static Connection getConnection() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Skriv user:");
        String user = sc.next();
        System.out.println("Skriv password");
        String password = sc.next();
        System.out.println("user: " + user + " : " + "password: " + password);

        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/demodemo?serverTimezone=CET&useSSL=false";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
