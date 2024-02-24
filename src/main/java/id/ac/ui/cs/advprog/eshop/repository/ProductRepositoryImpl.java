package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> productData = new ArrayList<>();
    private int idCounter = 99990000;

    @Override
    public Product add(Product product) {
        product.setProductId(Integer.toString(idCounter));
        idCounter++;
        productData.add(product);
        return product;
    }

    @Override
    public Product edit(Product product) {
        int productIndex = ProductRepoReader.findIndexById(productData, product.getProductId());
        productData.set(productIndex, product);
        return product;
    }

    @Override
    public void delete(Product product) {
        int productIndex = ProductRepoReader.findIndexById(productData, product.getProductId());
        productData.remove(productIndex);
    }

    @Override
    public List<Product> getData() {return productData;}

    /**
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public int findIndex(String productId){
        for(int i=0; i < productData.size(); i++) {
            if (productData.get(i).getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    public Product getProduct(String productId){
        int index = findIndex(productId);
        return productData.get(index);
    }
     **/
}
