import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/todo_app";
    private static final String USER = "root";
    private static final String PASSWORD = "123123";

    public static void main(String[] args) {
        try {
            // 1. 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 打开连接
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
