package fr.diginamic.jdbc;

import java.sql.*;

import fr.diginamic.entites.Article;
import org.mariadb.jdbc.Driver;

public class TestInsertion {

    public static void main(String[] args) throws SQLException {

        // 1 - je charge le driver
        DriverManager.registerDriver(new Driver());

        // 2 - je créé une connexion
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");

        // 3 - Variables
        Statement stat = conn.createStatement();
        ResultSet result = null;

        // 4 - J'affiche la liste des fournisseurs avant l'operation
        System.out.println("Liste originale des fournisseurs: \n-----------");
        result = stat.executeQuery("SELECT * FROM FOURNISSEUR");
        while (result.next()) {
            String nom = result.getString("NOM");
            int ID = result.getInt("ID");
            System.out.println(ID + ": " +nom);
        }

        // 5 - J'insère le nouveau fournisseur "La maison de la Peinture" dans la liste de fournisseurs
        int nb = stat.executeUpdate("INSERT into FOURNISSEUR (ID, NOM) VALUES (4, 'La Maison de la Peinture')");
        if (nb != 0) {
            System.out.println("\nL'insertion s'est bien passée.\n");
        }

        // 6 - J'affiche la liste des fournisseurs aprés l'operation
        System.out.println("Liste mise à jour des fournisseurs: \n-----------");
        result = stat.executeQuery("SELECT * FROM FOURNISSEUR");
        while (result.next()) {
            String nom = result.getString("NOM");
            int ID = result.getInt("ID");
            System.out.println(ID + ": " +nom);
        }

        stat.close(); // Indispensable / Ferme le statement
        conn.close(); // Indispensable / Ferme la connection
    }

}
