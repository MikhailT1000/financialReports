package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Operator")
public class Operator extends User {

    @OneToMany(fetch = FetchType.LAZY)
    private List<AllData> allData;

    public Operator() {
    }

    public Operator(String login) {
        setLogin(login);
    }

    public List<AllData> getAllData() {
        return allData;
    }

    public void setAllData(List<AllData> allData) {
        this.allData = allData;
    }
}
