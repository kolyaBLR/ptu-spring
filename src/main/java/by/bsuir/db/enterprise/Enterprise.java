package by.bsuir.db.enterprise;

import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.enterpriseproduct.EnterpriseProduct;
import by.bsuir.db.nameditem.NamedItem;
import by.bsuir.db.taggeditem.TaggedItem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "enterprise")
public class Enterprise implements Serializable {
    @Id
    @Column(name = "REGISTRATION_ID")
    private String registrationId;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "OWNER")
    private BaseUser owner;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NAMED_ITEM_ID")
    private NamedItem namedItem;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TAGGED_ITEM_ID")
    private TaggedItem taggedItem;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "APPROVED_BY")
    private BaseUser approvedBy;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Enterprise)) return false;
        return this.registrationId.equals(((Enterprise) obj).registrationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationId);
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public BaseUser getOwner() {
        return owner;
    }

    public void setOwner(BaseUser owner) {
        this.owner = owner;
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

    public BaseUser getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(BaseUser approvedBy) {
        this.approvedBy = approvedBy;
    }
}
