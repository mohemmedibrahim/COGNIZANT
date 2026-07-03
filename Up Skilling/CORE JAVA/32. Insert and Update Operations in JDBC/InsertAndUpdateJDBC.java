import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertAndUpdateJDBC {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();

        studentDAO.insertStudent(101, "Alice", 20);
        studentDAO.updateStudent(101, "Alice Johnson", 21);
    }
}

class StudentDAO {

    private final String url = "jdbc:mysql://localhost:3306/studentdb";
    private final String username = "root";
    private final String password = "root";

    public void insertStudent(int id, String name, int age) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);

            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " record inserted.");

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String name, int age) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setInt(3, id);

            int rows = preparedStatement.executeUpdate();

            System.out.println(rows + " record updated.");

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}