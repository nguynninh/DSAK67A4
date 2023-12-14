package project.main.user;

public class Main {
    public static void main(String[] args) {
        UserService userService = UserService.getInstance();
//        userService.addUser(new User(2, "Nguyen The", "nguyenthe", "1234434", "nguyenvannthe@gmail.com", true));
        userService.print();
    }
}
