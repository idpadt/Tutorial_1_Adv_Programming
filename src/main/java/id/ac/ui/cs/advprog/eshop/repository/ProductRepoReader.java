package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductRepoReader {

    /**
    public static List<Product> findAllData(ProductRepository productRepository) {
        Iterator<Product> productIterator = productRepository.getData();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }
     **/

    public static int findIndexById(List<Product> productRepository, String productId){
        for(int i=0; i < productRepository.size(); i++) {
            if (productRepository.get(i).getProductId().equals(productId)) {
                return i;
            }
        }
        return -1;
    }

    public static Product findProductById(List<Product> productRepository, String productId){
        int index = findIndexById(productRepository, productId);
        return productRepository.get(index);
    }
}
