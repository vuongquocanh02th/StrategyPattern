public class UserController {
    Storage userStorage;

    public UserController(Storage userStorage) {
        this.userStorage = userStorage;
    }
    public void store(User user) {
        userStorage.store(user);
    }
}
