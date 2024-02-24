package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductManipulatorService;
import id.ac.ui.cs.advprog.eshop.service.ProductReaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import jakarta.validation.*;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final String editPage = "editProduct";
    private final String createPage = "createProduct";
    private final String redirectToList = "redirect:list";

    @Autowired
    private ProductManipulatorService productManipulatorService;
    @Autowired
    private ProductReaderService productReaderService;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return createPage;
    }

    @PostMapping("/create")
    public String createProductPost(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return createPage; // Return to the form with error messages
        }
        productManipulatorService.create(product);
        return redirectToList;
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = productReaderService.getData();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @GetMapping("/edit/{productId}")
    public String createEditPage(@PathVariable String productId, Model model) {
        Product product = productReaderService.getProduct(productId);
        model.addAttribute("product", product);
        return editPage;
    }

    @PostMapping("/edit")
    public String updateProductPost(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return editPage;
        }
        productManipulatorService.update(product);
        return redirectToList;
    }

    @PostMapping("/delete")
    public String deleteProductPost(@ModelAttribute Product product, Model model){
        productManipulatorService.delete(product);
        return redirectToList;
    }
}