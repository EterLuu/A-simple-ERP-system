package pdc.assignment.erp.dbo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS", schema = "APP", catalog = "")
public class ItemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IID", nullable = false)
    private int iid;
    @Basic
    @Column(name = "NAME", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "PRICE", nullable = true)
    private BigDecimal price;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
