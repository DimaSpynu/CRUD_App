package org.example.controllers;

import org.example.models.Cart;
import org.example.models.Product;
import org.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    //    @PostMapping("/add")
//    public String addToCart(Long productId, Long cartId, int quantity) {
//        productService.addToCart(productId, cartId, quantity);
//        return "redirect:/cart/list";
//    }
        @PostMapping("/add")
        public String addToCart(@RequestParam Long productId, @RequestParam Long cartId, @RequestParam int quantity) {
            productService.addToCart(productId, cartId, quantity);
            return "redirect:/cart/list";
        }

        @DeleteMapping("/delete/{id}")
        public String deleteProduct (@PathVariable("id") Long id){
            productService.deleteProduct(id);
            return "redirect:/cart/list";
        }

        @GetMapping("/view")
        public String viewCart (Model model){
            Cart cart = new Cart();
            List<Product> products = productService.getAllProducts();
            model.addAttribute("cart", cart);
            model.addAttribute("products", products);
            return "cart/view";
        }

    }
