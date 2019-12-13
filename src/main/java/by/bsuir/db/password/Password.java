package by.bsuir.db.password;

import by.bsuir.db.baseuser.BaseUser;

import javax.persistence.*;

@Entity
@Table(name = "password")
public class Password {
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "LOGIN")
    private BaseUser user;

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public BaseUser getUser() {
        return user;
    }

    public void setUser(BaseUser user) {
        this.user = user;
    }
}
