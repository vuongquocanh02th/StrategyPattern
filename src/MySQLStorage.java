import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQLStorage implements Storage{
    @Override
    public void store(User user) {
        try {
            // Kết nối đến cơ sở dữ liệu MySQL
            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "root";
            String password = "password";

            Connection connection = DriverManager.getConnection(url, username, password);

            // SQL Insert
            String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());

            // Thực thi câu lệnh
            statement.executeUpdate();
            System.out.println("Đã lưu người dùng vào cơ sở dữ liệu MySQL!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
