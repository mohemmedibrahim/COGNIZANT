import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionHandlingJDBC {

    public static void main(String[] args) {

        AccountDAO accountDAO = new AccountDAO();

        accountDAO.transfer(1, 2, 500.0);
    }
}

class AccountDAO {

    private final String url = "jdbc:mysql://localhost:3306/bankdb";
    private final String username = "root";
    private final String password = "root";

    public void transfer(int fromAccount, int toAccount, double amount) {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);

            connection.setAutoCommit(false);

            String debitQuery = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
            PreparedStatement debitStatement = connection.prepareStatement(debitQuery);

            debitStatement.setDouble(1, amount);
            debitStatement.setInt(2, fromAccount);
            debitStatement.executeUpdate();

            String creditQuery = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            PreparedStatement creditStatement = connection.prepareStatement(creditQuery);

            creditStatement.setDouble(1, amount);
            creditStatement.setInt(2, toAccount);
            creditStatement.executeUpdate();

            connection.commit();

            System.out.println("Transaction completed successfully.");

            debitStatement.close();
            creditStatement.close();
            connection.close();

        } catch (Exception e) {

            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("Transaction rolled back.");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("Error: " + e.getMessage());
        }
    }
}