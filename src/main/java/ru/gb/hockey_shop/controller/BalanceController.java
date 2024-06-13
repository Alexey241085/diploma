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

    /**
     * страница пополнения счета
     *
     * @param id    счета в базе данных
     * @param model захватывает список счетов из БД (по умолчанию у нас один счет)
     * @return страница пополнения счета
     */
    @GetMapping("/account/{id}")
    public String addAccount(@PathVariable Long id, Model model) {
        Balance balance = balanceService.getAccountById(id).get();
        model.addAttribute("pay", balance);
        return "/account";
    }

    /**
     * @return после нажатия кнопки возвращает на страницу /cart
     * если пустое значение выводится log, если нет пополнение баланса
     */
    @PostMapping("/account/{id}")
    public String addCartProduct2(@PathVariable Long id, Balance balance) {
        try {
            balanceService.updateaAccoutn(id, balance);

        } catch (Exception e) {
            log.info("log - Нельзя отправить пустое значение");
            System.out.println("Нельзя отправить пустое значение");
        }
        return "redirect:/cart";
    }


}
