package by.bsuir.db.tag;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    @EmbeddedId
    private TagPK tagPK;

    public TagPK getTagPK() {
        return tagPK;
    }

    public void setTagPK(TagPK tagPK) {
        this.tagPK = tagPK;
    }
}
