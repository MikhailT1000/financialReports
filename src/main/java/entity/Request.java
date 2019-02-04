package entity;

import javax.persistence.*;

@Entity
@Table(name = "Requests")
public class Request {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Manager manager;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}