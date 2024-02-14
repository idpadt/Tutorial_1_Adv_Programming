package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
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

    String redirect_to_list = "redirect:list";

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "createProduct"; // Return to the form with error messages
        }
        service.create(product);
        return redirect_to_list;
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @GetMapping("/edit/{productId}")
    public String createEditPage(@PathVariable String productId, Model model) {
        Product product = service.getProduct(productId);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/edit")
    public String updateProductPost(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editProduct"; // Return to the form with error messages
        }
        service.update(product);
        return redirect_to_list;
    }

    @PostMapping("/delete")
    public String deleteProductPost(@ModelAttribute Product product, Model model){
        service.delete(product);
        return redirect_to_list;
    }
}
