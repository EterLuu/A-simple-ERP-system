package pdc.assignment.erp.dbo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "RECEIPT_DETAILS", schema = "APP", catalog = "")
public class ReceiptDetailsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DID", nullable = false)
    private int did;
    @Basic
    @Column(name = "RID", nullable = false)
    private int rid;
    @Basic
    @Column(name = "BID", nullable = false)
    private int bid;
    @Basic
    @Column(name = "BALANCE", nullable = false, precision = 0)
    private BigDecimal balance;
    @Basic
    @Column(name = "REMARK", nullable = true, length = 25)
    private String remark;

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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
}
