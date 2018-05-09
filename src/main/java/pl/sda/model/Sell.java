package pl.sda.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sells")
public class Sell extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Document document;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date sellDate;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "item=" + item +
                ", sellDate=" + sellDate +
                '}';
    }
}
