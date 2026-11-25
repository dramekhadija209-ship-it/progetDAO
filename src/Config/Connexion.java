package Config;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class Connexion {
    private static String URL ="jdbc:mysql://localhost:3306/Banque_de";
    private static String username ="myuser";
    private static String password = "mypassword";

    public static Connection ouvrir() throws SQLException {
        return null;
    }

    public static Connexion Ouvrir() {
        return null;
    }

    public PreparedStatement PrepareStatement(String sql) throws SQLException {
        return ouvrir().prepareStatement(sql);

    }

    public PreparedStatement prepareStatement(String sql) {
        return null;
    }
}
