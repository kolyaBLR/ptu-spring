package by.bsuir.db.product;

import by.bsuir.db.nameditem.NamedItem;
import by.bsuir.db.taggeditem.TaggedItem;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NAMED_ITEM_ID")
    private NamedItem namedItem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TAGGED_ITEM_ID")
    private TaggedItem taggedItem;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Product)) return false;
        return this.productId.equals(((Product) obj).productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
}
