package database;

import model.Schema;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DbBannedCards {

    Collection result;

    public Collection<Schema> bannedCardsDB() {

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }

        String URL = "jdbc:h2:~/test";
        String USER = "sa";
        String PASS = "";

        try (java.sql.Connection conn = DriverManager.getConnection(URL, USER, PASS);

            Statement st = conn.createStatement()){
            ResultSet rs = st.executeQuery("SELECT * FROM BANNEDCARDS;");

            Collection<Schema> collectionBannedCards = new ArrayList<>();
            while (rs.next()){
                Schema current = new Schema();
                current.id = rs.getInt("ID");
                current.name = rs.getString("Name");
                collectionBannedCards.add(current);
            }
            result = collectionBannedCards;
        } catch (SQLException throwables) {
                throwables.printStackTrace();
        }
        return result;
    }
}
