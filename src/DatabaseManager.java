import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/todo";  // 确保数据库名称是 'todo'
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // 1. 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. 打开连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. 创建一个表（如果不存在）
            String createTableSQL = "CREATE TABLE IF NOT EXISTS tasks ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "task_name VARCHAR(255) NOT NULL, "
                    + "status BOOLEAN DEFAULT FALSE)";
            PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL);
            createTableStatement.execute();

            // 4. 插入数据
            String insertSQL = "INSERT INTO tasks (task_name, status) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
            insertStatement.setString(1, "Sample Task");
            insertStatement.setBoolean(2, false);
            insertStatement.executeUpdate();

            // 5. 查询数据
            String selectSQL = "SELECT * FROM tasks";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();

            // 6. 展示数据
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String taskName = resultSet.getString("task_name");
                boolean status = resultSet.getBoolean("status");
                System.out.println("ID: " + id + ", Task: " + taskName + ", Status: " + status);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
