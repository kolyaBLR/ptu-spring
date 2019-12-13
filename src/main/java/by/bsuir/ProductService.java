package by.bsuir;

import by.bsuir.auth.AuthManager;
import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.baseuser.BaseUserDAO;
import by.bsuir.db.baseuser.BaseUserType;
import by.bsuir.db.enterprise.Enterprise;
import by.bsuir.db.enterpriseproduct.EnterpriseProduct;
import by.bsuir.db.enterpriseproduct.EnterpriseProductDAO;
import by.bsuir.db.product.Product;
import by.bsuir.db.product.ProductDAO;
import by.bsuir.db.taggeditem.TaggedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private AuthManager authManager;
    @Autowired
    private BaseUserDAO baseUserDAO;
    @Autowired
    private EnterpriseProductDAO enterpriseProductDAO;

    public Product getProduct(Integer id)
    {
        return productDAO.read(id, Product.class);
    }

    public List<Product> getAll()
    {
        return productDAO.readAll(Product.class);
    }

    public boolean canCreateProduct(HttpSession httpSession)
    {
        String login = authManager.checkAuth(httpSession);
        return login != null;
    }

    public void createProduct(Product product, HttpSession httpSession)
    {
        product.setTaggedItem(new TaggedItem());
        productDAO.create(product);
    }

    public List<EnterpriseProduct> getEnterpriseProductsFor(Enterprise enterprise)
    {
        return enterpriseProductDAO.readAllFor(enterprise);
    }

    public void addEnterpriseProduct(EnterpriseProduct enterpriseProduct, Enterprise enterprise)
    {
        enterpriseProduct.getEnterpriseProductPK().setEnterprise(enterprise);
        enterpriseProduct.getEnterpriseProductPK()
                .setProduct(productDAO.read(enterpriseProduct.getEnterpriseProductPK().getProduct().getProductId(), Product.class));
        if (enterpriseProductDAO.read(enterpriseProduct.getEnterpriseProductPK(), EnterpriseProduct.class) != null)
        {
            EnterpriseProduct e = enterpriseProductDAO.read(enterpriseProduct.getEnterpriseProductPK(), EnterpriseProduct.class);
            e.setCost(enterpriseProduct.getCost());
            e.setAmount(enterpriseProduct.getAmount());
            return;
        }
        enterpriseProductDAO.create(enterpriseProduct);
    }
}
