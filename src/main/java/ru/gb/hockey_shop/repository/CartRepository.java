package ru.gb.hockey_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.hockey_shop.model.product.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
