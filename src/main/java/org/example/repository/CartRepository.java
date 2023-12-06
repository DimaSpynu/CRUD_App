package org.example.repository;

import org.example.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // здесь вы можете добавить пользовательские методы для работы с корзиной

    @Override
    Optional<Cart> findById(Long aLong);
}
