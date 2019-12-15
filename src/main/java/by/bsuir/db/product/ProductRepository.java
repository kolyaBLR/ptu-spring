package by.bsuir.db.product;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.placement.Placement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository extends SimpleCRUD<Product, String> implements CRUD<Product, String> {

    @Override
    public Product findFirst(Integer companyId) {
        List<Product> items = readAll(Product.class);
        for (Product item : items) {
            if (item.getCompanyId() == companyId) {
                return item;
            }
        }
        return null;
    }
}
