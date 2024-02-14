package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindIndex() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        int index = productRepository.findIndex("99990000");
        assertEquals("0", String.valueOf(index));

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        index = productRepository.findIndex("99990001");
        assertEquals("1", String.valueOf(index));
        index = productRepository.findIndex("99990000");
        assertEquals("0", String.valueOf(index));

        index = productRepository.findIndex("99990003");
        assertEquals("-1", String.valueOf(index));


    }

    @Test
    void testFindProduct() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product product = productRepository.getProduct("99990000");
        assertEquals(product1, product);
        product = productRepository.getProduct("99990001");
        assertEquals(product2, product);
    }

    @Test
    void testUpdateProduct() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("99990000");
        product2.setProductName("Sampo Sop Sampo");
        product2.setProductQuantity(500);
        productRepository.update(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        Product product = productIterator.next();
        assertNotEquals(product1, product);
        assertEquals(product2, product);
    }

    @Test
    void testDeleteProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        productRepository.delete(product1);
        productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        assertEquals(product2, productIterator.next());
        productRepository.delete(product2);
        productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());

    }
}