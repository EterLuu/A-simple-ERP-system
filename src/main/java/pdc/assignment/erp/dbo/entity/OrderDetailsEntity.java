package pdc.assignment.erp.dbo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ORDER_DETAILS", schema = "APP", catalog = "")
public class OrderDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DID", nullable = false)
    private long did;
    @Basic
    @Column(name = "OID", nullable = true)
    private Integer oid;
    @Basic
    @Column(name = "IID", nullable = true)
    private Integer iid;
    @Basic
    @Column(name = "PRICE", nullable = true)
    private BigDecimal price;
    @Basic
    @Column(name = "NUMBER", nullable = true)
    private BigDecimal number;
    @Basic
    @Column(name = "TOTAL_PRICE", nullable = true)
    private BigDecimal totalPrice;
    @Basic
    @Column(name = "REMARK", nullable = true, length = 255)
    private String remark;

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
