package pdc.assignment.erp.dbo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "ORDERS", schema = "APP", catalog = "")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OID", nullable = false)
    private int oid;
    @Basic
    @Column(name = "CID", nullable = false)
    private Integer cid;
    @Basic
    @Column(name = "UID", nullable = false)
    private Integer uid;
    @Basic
    @Column(name = "TIME", nullable = false)
    private Timestamp time;
    @Basic
    @Column(name = "PRICE", nullable = true, precision = 0)
    private BigDecimal price;
    @Basic
    @Column(name = "REMARK", nullable = true, length = 255)
    private String remark;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
