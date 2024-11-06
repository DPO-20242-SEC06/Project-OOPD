package user_role_management.user_management;

public abstract class User {
    protected String username;
    protected String password;
    protected String name;
    protected String email;

    public User(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

}
