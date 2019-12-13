package by.bsuir.db.product;

import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class ProductHiber extends SimpleCRUD<Product, Integer> implements ProductDAO {
}
