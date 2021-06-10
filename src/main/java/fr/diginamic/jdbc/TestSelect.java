package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.mariadb.jdbc.Driver;

import fr.diginamic.entites.Article;

public class TestSelect {

    public static void main(String[] args) {

        ArrayList<Article> listeArticles = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;

        try {
            // 1 - je charge le driver
            DriverManager.registerDriver(new Driver());

            // 2 - je créé une connexion
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta", "root", "");
            stat = conn.createStatement();

            // 3 - J'extrait les données de la liste de fournisseurs
            result = stat.executeQuery("SELECT * FROM FOURNISSEUR");

            // 4 - Je fais une boucle: tant qu'il y'as des fournisseurs, je récupere l'ID et le nom que je stock dans ma liste
            while (result.next()) {
                int id = result.getInt("ID");
                String nom = result.getString("NOM");

                Article article = new Article(id, nom);
                listeArticles.add(article);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Problème de fermeture des ressources :" + e.getMessage());
            }
        }

        //5 - J'affiche le contenu de ma liste
        System.out.println("Liste des fournisseurs récupérée de la base de données: \n-----------");
        for (Article article : listeArticles) {
            System.out.println(article.getNom());
        }
    }

}
