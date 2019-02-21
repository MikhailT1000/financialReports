package web;

public class AddUserPageBean {
    private final String typeUser;
    private final String firstName;
    private final String secondName;
    private final String login;
    private final String loginError;

    public AddUserPageBean(String typeUser, String firstName, String secondName, String login, String loginError) {
        this.typeUser = typeUser;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.loginError = loginError;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLogin() {
        return login;
    }

    public String getLoginError() {
        return loginError;
    }
}