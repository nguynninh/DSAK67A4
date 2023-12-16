package project.main.user;

public class User {
    private int id;
    private String email;
    private String password;
    private String fullname;
    private long scores;
    private int role;

    public User(int id, String email, String password, String fullname, long scores, int role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.scores = scores;
        this.role = role;
    }

    public User(int id, String email, String password, String fullname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.scores = 0;
        this.role = 1;
    }

    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.role = 1;
    }

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getScores() {
        return scores;
    }

    public String getRole() {
        String s = "";

        switch (role) {
            case 0 -> s = "";
            case 1 -> s = "User";
            case 2 -> s = "Admin";
            case 3 -> s = "SuperAdmin";
        }

        return s;
    }

    public int getRoleToInt(){
        return role;
    }

    public String getRole(User user) {
        String s = "";

        switch (Math.max(this.role, user.role)){
            case 0 -> s = "";
            case 1 -> s = "User";
            case 2 -> s = "Admin";
            case 3 -> s = "SuperAdmin";
        }

        return s;
    }

    public boolean isEmpty(){
        return role == 0;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setScores(long scores) {
        this.scores = scores;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
