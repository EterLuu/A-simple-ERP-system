package pdc.assignment.erp.dbo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BANKACCOUNTS", schema = "APP", catalog = "")
public class BankAccountsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "BID", nullable = false)
    private int bid;
    @Basic
    @Column(name = "NAME", nullable = false, length = 25)
    private String name;
    @Basic
    @Column(name = "CARD", nullable = true, length = 100)
    private String card;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
