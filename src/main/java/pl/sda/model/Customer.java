package pl.sda.model;

import javax.persistence.*;
import java.util.Set;


@Entity
    @Table(name = "customers")
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    public class Customer extends AbstractEntity {


    @OneToMany(mappedBy = "customer")
    private Set<Document> documents;


    @Column
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
