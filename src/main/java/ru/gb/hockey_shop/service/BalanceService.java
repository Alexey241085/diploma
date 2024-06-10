package ru.gb.hockey_shop.service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hockey_shop.model.Balance;
import ru.gb.hockey_shop.repository.BalanceRepozitory;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BalanceService {

    @Autowired
    private BalanceRepozitory balanceRepozitory;


    public List<Balance> showAccount() {
        return balanceRepozitory.findAll();
    }

    public Optional<Balance> getAccountById(Long id) {
        return balanceRepozitory.findById(id);
    }


//    public Balance creatBalance() {
//        Balance balance = new Balance();
//        balance.setAccount(0.0);
//        return balanceRepozitory.save(balance);
//    }

    public Balance updateaAccoutn(Long id, Balance updateBalance) {
        Optional<Balance> optBalance = balanceRepozitory.findById(id);
        if (optBalance.isPresent()) {
            Balance balance = optBalance.get();
            balance.setAccount(updateBalance.getAccount() + balance.getAccount());
            return balanceRepozitory.save(balance);
        } else {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
    }


    public Balance updateaAccoutnPay(Long id, Balance updateBalance) {
        Optional<Balance> optBalance = balanceRepozitory.findById(id);
        if (optBalance.isPresent()) {
            Balance balance = optBalance.get();
            balance.setAccount(updateBalance.getAccount());
            return balanceRepozitory.save(balance);
        } else {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
    }





}
