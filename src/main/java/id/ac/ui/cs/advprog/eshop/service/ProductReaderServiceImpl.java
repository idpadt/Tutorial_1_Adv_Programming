package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepoReader;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductReaderServiceImpl implements ProductReaderService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getData() {
        return productRepository.getData();
    }

    @Override
    public Product getProduct(String productId) {
        return ProductRepoReader.findProductById(productRepository.getData(), productId);
    }
}