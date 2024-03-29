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
public class ProductManipulatorServiceImpl implements ProductManipulatorService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        productRepository.add(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        productRepository.edit(product);
        return product;
    }

    @Override
    public Product delete(Product product) {
        productRepository.delete(product);
        return product;
    }
}