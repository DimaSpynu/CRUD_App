package org.example.dao;

import org.example.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> index() {
        return jdbcTemplate.query("SELECT * FROM product", new BeanPropertyRowMapper<>(Product.class));
    }

    public Product show(final Long id) {
        return jdbcTemplate.query("SELECT * FROM product WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Product.class))
                .stream().findAny().orElse(null);
    }

    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO product (name, description, price) VALUES (?, ?, ?)",
                product.getName(), product.getDescription(), product.getPrice());
    }

    public void update(Long id, Product updatedProduct) {
        jdbcTemplate.update("UPDATE product SET name=?, description=?, price=? WHERE id=?",
                updatedProduct.getName(), updatedProduct.getDescription(), updatedProduct.getPrice(), id);
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM product WHERE id=?", id);
    }
}

