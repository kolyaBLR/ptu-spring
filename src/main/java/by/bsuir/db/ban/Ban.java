package by.bsuir.db.ban;

import by.bsuir.db.baseuser.BaseUser;

import javax.persistence.*;

@Entity
@Table(name = "ban")
public class Ban {

    @Id
    @Column(name = "USER")
    private String userLogin;

    @Column(name = "REASON")
    private String reason;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "USER")
    private BaseUser user;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public BaseUser getUser() {
        return user;
    }

    public void setUser(BaseUser user) {
        this.user = user;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
