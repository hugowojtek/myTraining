package pl.sda.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "documents")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Document extends AbstractEntity {

    @OneToMany(mappedBy = "document",cascade = CascadeType.ALL)
    private Set<Sell> sells;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Set<Sell> getSells() {
        return sells;
    }

    public void setSells(Set<Sell> sells) {
        this.sells = sells;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
