package by.bsuir.db.product;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends SimpleCRUD<Product, String> implements CRUD<Product, String> {
}
