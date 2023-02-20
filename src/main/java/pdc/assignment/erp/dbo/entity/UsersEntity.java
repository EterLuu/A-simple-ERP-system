package pdc.assignment.erp.dbo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "USERS", schema = "APP", catalog = "")
public class UsersEntity {
    @Basic
    @Column(name = "PASSWORD", nullable = true, length = 255)
    private String password;
    @Basic
    @Column(name = "ROLE", nullable = true)
    private Integer role;
    @Basic
    @Column(name = "REGISTER_TIME", nullable = true)
    private Timestamp registerTime;
    @Basic
    @Column(name = "LAST_LOGIN_TIME", nullable = true)
    private Timestamp lastLoginTime;
    @Basic
    @Column(name = "USERNAME", nullable = true, length = 255)
    private String username;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "UID", nullable = false)
    private int uid;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
