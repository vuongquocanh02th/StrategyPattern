public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng User
        User user = new User("John Doe", "john.doe@example.com");

        // Sử dụng XMLStorage để lưu trữ người dùng
        Storage xmlStorage = new XMLStorage();
        UserController userControllerXML = new UserController(xmlStorage);

        // Lưu người dùng vào XML
        userControllerXML.store(user);
    }
}