package by.bsuir.db.baseuser;

import by.bsuir.db.nameditem.NamedItem;
import by.bsuir.db.password.Password;
import by.bsuir.db.project.Project;
import by.bsuir.db.taggeditem.TaggedItem;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class BaseUser implements Serializable {
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "BIRTH_DAY")
    private Timestamp birthDay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TAGGED_ITEM_ID")
    private TaggedItem taggedItem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NAMED_ITEM_ID")
    private NamedItem namedItem;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "LOGIN")
    private Password password;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_follow",
            joinColumns = @JoinColumn(name = "USER"),
            inverseJoinColumns =  @JoinColumn(name = "PROJECT")
    )
    private Set<Project> followedProjects = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BaseUser)) return false;
        return this.login.equals(((BaseUser) obj).login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }

    public TaggedItem getTaggedItem() {
        return taggedItem;
    }

    public void setTaggedItem(TaggedItem taggedItem) {
        this.taggedItem = taggedItem;
    }

    public NamedItem getNamedItem() {
        return namedItem;
    }

    public void setNamedItem(NamedItem namedItem) {
        this.namedItem = namedItem;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Set<Project> getFollowedProjects() {
        return followedProjects;
    }

    public void setFollowedProjects(Set<Project> followedProjects) {
        this.followedProjects = followedProjects;
    }
}
