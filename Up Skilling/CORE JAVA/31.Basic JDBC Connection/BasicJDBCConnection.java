import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJDBCConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getInt("id") +
                        ", Name: " + resultSet.getString("name") +
                        ", Age: " + resultSet.getInt("age"));
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}