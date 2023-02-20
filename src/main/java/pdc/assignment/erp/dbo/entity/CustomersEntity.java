package pdc.assignment.erp.dbo.entity;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS", schema = "APP", catalog = "")
public class CustomersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CID", nullable = false)
    private int cid;
    @Basic
    @Column(name = "NAME", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "ADDRESS", nullable = false, length = 255)
    private String address;
    @Basic
    @Column(name = "TELEPHONE", nullable = false, length = 255)
    private String telephone;
    @Basic
    @Column(name = "FAX", nullable = true, length = 25)
    private String fax;
    @Basic
    @Column(name = "REMARK", nullable = true, length = 255)
    private String remark;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
