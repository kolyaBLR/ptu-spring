package by.bsuir.db.project;

import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.nameditem.NamedItem;
import by.bsuir.db.taggeditem.TaggedItem;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NAMED_ITEM_ID")
    private NamedItem namedItem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TAGGED_ITEM_ID")
    private TaggedItem taggedItem;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "CREATOR")
    private BaseUser creator;

    @Column(name = "CREATION_DATE")
    private Timestamp creationDate;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_follow",
            joinColumns = @JoinColumn(name = "PROJECT"),
            inverseJoinColumns =  @JoinColumn(name = "USER")
    )
    private Set<BaseUser> followers = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Project)) return false;
        return this.id.equals(((Project) obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NamedItem getNamedItem() {
        return namedItem;
    }

    public void setNamedItem(NamedItem namedItem) {
        this.namedItem = namedItem;
    }

    public TaggedItem getTaggedItem() {
        return taggedItem;
    }

    public void setTaggedItem(TaggedItem taggedItem) {
        this.taggedItem = taggedItem;
    }

    public BaseUser getCreator() {
        return creator;
    }

    public void setCreator(BaseUser creator) {
        this.creator = creator;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Set<BaseUser> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<BaseUser> followers) {
        this.followers = followers;
    }
}
