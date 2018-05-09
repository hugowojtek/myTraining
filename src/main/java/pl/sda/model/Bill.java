package pl.sda.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Bill extends Document {

    @Column
    private String stamp;

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }
}
