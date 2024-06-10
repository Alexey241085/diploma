package ru.gb.hockey_shop.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.hockey_shop.model.Balance;
import ru.gb.hockey_shop.model.product.Product;
import ru.gb.hockey_shop.service.BalanceService;

import java.util.List;

@Controller
@Log
@AllArgsConstructor
//@RequestMapping("/cart")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;


    @GetMapping("/account/{id}")
    public String addAccount(@PathVariable Long id, Model model){
        Balance balance = balanceService.getAccountById(id).get();
        model.addAttribute("pay", balance);
        System.out.println(balance);
        return "/account";
    }

    @PostMapping("/account/{id}")
    public String addCartProduct2(@PathVariable Long id, Balance balance){
        try {
            balanceService.updateaAccoutn(id,balance);

        }catch (Exception e){
            log.info("log - Нельзя отправить пустое значение");
            System.out.println("Нельзя отправить пустое значение");
        }
        return "redirect:/cart";
    }

//    @PostMapping("/account/{id}")
//    public String addCartProduct(@PathVariable("id") Long id, Balance balance){
//        balanceService.updateaAccoutn(id,balance);
//
//
//        return "cart";
//    }


//    @GetMapping("/account-update{id}")
//    public String addBalance(@PathVariable Long id, Model model){
//        List<Balance> listBalance = balanceService.showAccount();
//
//
//        model.addAttribute("balance", balanceService.getAccountById(id));
//        return "account-update";
//    }



//    @GetMapping("/account-update/{id}")
//    public String upBalanc(@PathVariable Long id, Model model) {
//        model.addAttribute("uppPay",balanceService.getAccountById(id).get());
//        return "account-update";
//    }



}
