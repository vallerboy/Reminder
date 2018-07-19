package pl.oskarpolak.reminder.models;

public class UserInstance {
    private static UserInstance ourInstance = new UserInstance();

    public static UserInstance getInstance() {
        return ourInstance;
    }

    private boolean isUserLogin;
    private String username;

    private UserInstance() {
    }


    public boolean isUserLogin() {
        return isUserLogin;
    }

    public void setUserLogin(boolean userLogin) {
        isUserLogin = userLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
