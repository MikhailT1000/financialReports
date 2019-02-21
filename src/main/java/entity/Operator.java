package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Operator")
public class Operator extends User {

    @OneToMany(fetch = FetchType.LAZY,
            //            cascade = { CascadeType.PERSIST, CascadeType.REMOVE },
            mappedBy = "operator"
    )
//    @JoinTable(
//            name = "operators_allDatas_map",
//            joinColumns = @JoinColumn(name = "operator_fk", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "allData_fk", referencedColumnName = "id")
//    )
    private List<AllData> allData;

    public Operator() {
    }

    public Operator(String firstName, String secondName, String login) {
        setFirstName(firstName);
        setSecondName(secondName);
        setLogin(login);
    }

    public List<AllData> getAllData() {
        return allData;
    }

    public void setAllData(List<AllData> allData) {
        this.allData = allData;
    }
}
