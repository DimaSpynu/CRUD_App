package org.example.repository;

import org.example.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // здесь вы можете добавить пользовательские методы для работы с товарами в корзине
}

