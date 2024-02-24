package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public interface ProductReaderService {

    public List<Product> getData();
    public Product getProduct(String productId);
}
