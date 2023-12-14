package project.main.user;

public class User {
    public int id;
    public String fullname;
    public String username;
    public String password;
    public String email;
    public boolean isEmpty;

    public User(int id, String fullname, String username, String password, String email, boolean isEmpty) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isEmpty = isEmpty;
    }

    public User(String fullname, String username, String password, String email) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User " + id + ": " +
                "\n\tfullname='" + fullname + '\'' +
                "\n\tusername='" + username + '\'' +
                "\n\tpassword='" + password + '\'' +
                "\n\temail='" + email + '\'' +
                "\n\tisEmpty=" + isEmpty;
    }
}
