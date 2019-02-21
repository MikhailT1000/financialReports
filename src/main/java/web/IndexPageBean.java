package web;

import entity.User;
import java.util.Date;
import java.util.List;

public class IndexPageBean {
    private final Date currentDate;
    private final List<User> users;

    public IndexPageBean(Date currentDate, List<User> users) {
        this.currentDate = currentDate;
        this.users = users;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public List<User> getUsers() {
        return users;
    }
}