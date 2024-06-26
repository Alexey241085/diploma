package ru.gb.hockey_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.hockey_shop.model.product.Product;

// репозиторий для класса Product
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
