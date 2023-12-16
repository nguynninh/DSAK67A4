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
        User user = userRepository.getUserByEmail(username);
        return user != null && BCrypt.checkpw(password, user.getPassword()) && user.getRoleToInt() >= 0;
    }


    public boolean addUser(User newUser) {
        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt(12)));
        return userRepository.addUser(newUser);
    }

    public void updateUser(int userId, String newFullname, String newPassword, String newEmail) {
        User existingUser = userRepository.getUserById(userId);

        if (existingUser != null) {
            existingUser.setFullname(newFullname);
            existingUser.setPassword(newPassword);
            existingUser.setEmail(newEmail);

            userRepository.updateUser(existingUser);
        }
    }

    public void softDeleteUser(int userId) {
        User existingUser = userRepository.getUserById(userId);

        if (existingUser != null) {
            existingUser.setRole(0);
            userRepository.updateUser(existingUser);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
    public User getUsers(String email) {
        return userRepository.getUserByEmail(email);
    }

    public void print() {
        getAllUsers().forEach(System.out::println);
    }
}
