package pl.sda.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "companies")
public class Company extends Customer {
    private String regon;

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }
}
