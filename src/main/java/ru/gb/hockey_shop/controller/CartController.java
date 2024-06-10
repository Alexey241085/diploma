package ru.gb.hockey_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.hockey_shop.model.Balance;
import ru.gb.hockey_shop.model.Person;
import ru.gb.hockey_shop.model.product.Cart;
import ru.gb.hockey_shop.model.product.Product;
import ru.gb.hockey_shop.service.BalanceService;
import ru.gb.hockey_shop.service.CartService;
import ru.gb.hockey_shop.service.PersonService;
import ru.gb.hockey_shop.service.ProductService;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private PersonService personService;
    @Autowired
    private ProductService productService;

    @Autowired
    private BalanceService balanceService;


//    @GetMapping("/cart")
//    public String showCartProducts(){
//        cartService.getCartProducts();
//        return "cart";
//    }


    @GetMapping("/cart")
    public String showProductSkates(Model model) {
        List<Cart> listCartProduct = cartService.getCartProducts();
        Long count = countProductsCart(listCartProduct);
        Integer summPriceProduct = summPriceProductsCart(listCartProduct);

        List<Balance> listBalance = balanceService.showAccount();

        model.addAttribute("balance", listBalance);
        model.addAttribute("cartProducts", listCartProduct);
        model.addAttribute("countPruductCart", count);
        model.addAttribute("summPriceProduct", summPriceProduct);

        return "cart";
    }


    @GetMapping("/pay-update")
    public String showOk(Model model) {
        List<Cart> listCartProduct = cartService.getCartProducts();

        Integer summPriceProduct = summPriceProductsCart(listCartProduct);

        List<Balance> listBalance = balanceService.showAccount();

        model.addAttribute("balance", listBalance);
        model.addAttribute("cartProducts", listCartProduct);

        model.addAttribute("summPriceProduct", summPriceProduct);
        return "pay-update";
    }


    @PostMapping("/pay-update")
    public String updateaAccoutnPayCart() {
        List<Cart> listCartProduct = cartService.getCartProducts();
        Integer summPriceProduct = summPriceProductsCart(listCartProduct);

        System.out.println("сумма товаров "+summPriceProduct);

        Long a = 1L;

        Double balanceAccount = balanceService.showAccount().stream()
                .filter(b -> b.getId().equals(a)).map(Balance::getAccount).findFirst().get();
        Double result = balanceAccount - summPriceProduct;

        System.out.println("баланс "+balanceAccount);

        System.out.println("результат "+ result);

        if (result >= 0) {
            Long id;
            Optional<Balance> optBalanse = balanceService.showAccount()
                    .stream().filter(s -> s.getId().equals(a)).findFirst();
                Balance balance2 = optBalanse.get();
                balance2.setAccount(result);
            System.out.println(balance2);
                balanceService.updateaAccoutnPay(a, balance2);
                cartService.deleteAllCartProduct();

            }
        else System.out.println("недостаточно средств");

//        }

        return "redirect:/cart";
    }


//    @PostMapping("/cart-pay")
//    public String payCart() {
//        List<Cart> listCartProduct = cartService.getCartProducts();
//        Double balance = balanceService.showAccount().stream()
//                .filter(b -> b.getId().equals(1))
//                .findFirst().map(s -> s.getAccount().doubleValue()).get();
//
//        Integer summPriceProduct = summPriceProductsCart(listCartProduct);
//
//
//        return "cart";
//    }

//


    @GetMapping("/cart-delete/{id}")
    public String deleteCartById(@PathVariable Long id) {
        cartService.deleteCartProduct(id);
        return "redirect:/cart";
    }


    // переносит продукт в карзину
    @PostMapping("/cart/{id}")
    public String addCartProduct(@PathVariable("id") Product product) {
        cartService.createCartProduct(product);
        return "cart";
    }


    private Long countProductsCart(List<Cart> listCartProduct) {
        Long count = cartService.getCartProducts().stream().count();
        return count;
    }


    //    private Integer summPriceProductsCart(List<Cart> listCartProduct) {
    private Integer summPriceProductsCart(List<Cart> listCartProduct) {
        Integer summPrice = cartService.getCartProducts()
                .stream()
                .map(Cart::getCartPrice)
                .reduce(0, Integer::sum);
        return summPrice;
    }


//    private void payCartResult() {
//        try {
//            List<Cart> listCartProduct = cartService.getCartProducts();
//            Integer summPriceProduct = summPriceProductsCart(listCartProduct);
//
//            Double balance = balanceService.showAccount().stream()
//                    .filter(b -> b.getId().equals(1))
//                    .findFirst().map(s -> s.getAccount().doubleValue()).get();
//
//            Double result = balance - summPriceProduct;
//
//            if (result >= 0) {
//                cartService.deleteAllCartProduct();
//            }
//        } catch (Exception e) {
//
//        else{
//                System.out.println("Надостаточно средст");
//            }
//
//
//        }
//
//
//    }

    @GetMapping("/pay-uodate")
    private String payComplite() {

        return "pay-uodate";
    }

}
