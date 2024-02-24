package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
import java.util.Iterator;

public interface ProductRepository {

    public Product add(Product product);

    public Product edit(Product product);

    public void delete(Product product);

    public List<Product> getData();
}
