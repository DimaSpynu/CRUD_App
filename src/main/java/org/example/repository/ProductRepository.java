package org.example.repository;

import org.example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // здесь вы можете добавить пользовательские методы для работы с товарами

    @Override
    Optional<Product> findById(Long aLong);
}

