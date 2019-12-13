package by.bsuir.db.tag;

import by.bsuir.db.taggeditem.TaggedItem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TagPK implements Serializable {
    @Column(name = "TAG")
    private String tag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TAGGED_ITEM_ID")
    private TaggedItem taggedItem;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof TagPK)) return false;
        return this.tag.equals(((TagPK) obj).tag)
                && this.taggedItem.equals(((TagPK) obj).taggedItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, taggedItem);
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public TaggedItem getTaggedItem() {
        return taggedItem;
    }

    public void setTaggedItem(TaggedItem taggedItem) {
        this.taggedItem = taggedItem;
    }
}
