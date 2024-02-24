package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductManipulatorService {

    public Product create(Product product);
    public Product update(Product product);
    public Product delete(Product product);
}
