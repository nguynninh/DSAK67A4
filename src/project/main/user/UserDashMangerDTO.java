package project.main.user;

public class UserDashMangerDTO {
    private String email;
    private String fullname;
    private ERole role;
    private enum ERole {
        ADMIN,
        SUPER_ADMIN
    }

    public UserDashMangerDTO(String email, String fullname, ERole role) {
        this.email = email;
        this.fullname = fullname;
        this.role = role;
    }
}
