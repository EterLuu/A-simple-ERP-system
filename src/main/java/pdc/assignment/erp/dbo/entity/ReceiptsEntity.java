package pdc.assignment.erp.dbo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "RECEIPTS", schema = "APP", catalog = "")
public class ReceiptsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "RID", nullable = false)
    private int rid;
    @Basic
    @Column(name = "CID", nullable = false)
    private int cid;
    @Basic
    @Column(name = "UID", nullable = false)
    private int uid;
    @Basic
    @Column(name = "BALANCE", nullable = false, precision = 0)
    private BigDecimal balance;
    @Basic
    @Column(name = "REMARK", nullable = true, length = 255)
    private String remark;
    @Basic
    @Column(name = "TIME", nullable = false)
    private Timestamp time;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
