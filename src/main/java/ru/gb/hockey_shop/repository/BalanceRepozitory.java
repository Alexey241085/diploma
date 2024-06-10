package ru.gb.hockey_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.hockey_shop.model.Balance;

@Repository
public interface BalanceRepozitory extends JpaRepository<Balance,Long> {
}
