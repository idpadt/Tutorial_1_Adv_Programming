package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private int idCounter = 0;

    public Product create(Product product) {
        product.setProductId(Integer.toString(idCounter));
        idCounter++;
        productData.add(product);
        return product;
    }

    public Product update(Product product) {
        int productIndex = Integer.parseInt(product.getProductId());
        productData.set(productIndex, product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findProduct(int productId){return productData.get(productId);}
}
