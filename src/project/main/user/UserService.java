package project.main.user;

import org.mindrot.bcrypt.BCrypt;

import java.util.List;

public class UserService {
    private static UserService instance;
    private final UserRepository userRepository;

    private UserService() {
        userRepository = new UserRepository();
    }

    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }

    public boolean loginUser(String username, String password) {
        User user = userRepository.getUserByUsernameOrEmail(username);
        return user != null && BCrypt.checkpw(password, user.password);
    }


    public boolean addUser(User newUser) {
        newUser.isEmpty = true;
        newUser.password = BCrypt.hashpw(newUser.password, BCrypt.gensalt(12));
        return userRepository.addUser(newUser);
    }

    public void updateUser(int userId, String newFullname, String newUsername, String newPassword, String newEmail) {
        User existingUser = userRepository.getUserById(userId);

        if (existingUser != null) {
            existingUser.fullname = newFullname;
            existingUser.username = newUsername;
            existingUser.password = newPassword;
            existingUser.email = newEmail;

            userRepository.updateUser(existingUser);
        }
    }

    public void softDeleteUser(int userId) {
        User existingUser = userRepository.getUserById(userId);

        if (existingUser != null) {
            existingUser.isEmpty = false;
            userRepository.updateUser(existingUser);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void print() {
        getAllUsers().forEach(System.out::println);
    }
}
