package org.example.exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(Long cartId) {
        super("Product not found with id : " + cartId);
    }
}
