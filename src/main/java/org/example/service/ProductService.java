package org.example.service;


import org.example.exception.CartNotFoundException;
import org.example.exception.ProductNotFoundException;
import org.example.models.Cart;
import org.example.models.CartItem;
import org.example.models.Product;
import org.example.repository.CartItemRepository;
import org.example.repository.CartRepository;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CartItemRepository cartItemRepository;
    private CartRepository cartRepository;

    // конструктор

    public void addToCart(Long productId, Long cartId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(quantity);

        cartItemRepository.save(cartItem);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
