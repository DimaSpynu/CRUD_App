package org.example.controllers;

import org.example.dao.ProductDAO;
import org.example.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductDAO productDAO;

    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping("/list")
    public String listProducts(Model model) {
        List<Product> products = productDAO.index();
        model.addAttribute("products", products);
        return "products/list";
    }

    @GetMapping("/show/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
        Product product = productDAO.show(id);
        model.addAttribute("product", product);
        return "products/show";
    }

    @GetMapping("/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/new";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productDAO.save(product);
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable("id") Long id) {
        Product product = productDAO.show(id);
        model.addAttribute("products", product);
        return "products/edit";
    }

    @PatchMapping("/update/{id}")
    public String updateProduct(@ModelAttribute Product product, @PathVariable("id") Long id) {
        productDAO.update(id, product);
        return "redirect:/products/list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productDAO.delete(id);
        return "redirect:/products/list";
    }
}
