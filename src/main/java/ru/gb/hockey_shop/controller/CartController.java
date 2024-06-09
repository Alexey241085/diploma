package ru.gb.hockey_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.hockey_shop.model.product.Cart;
import ru.gb.hockey_shop.model.product.Product;
import ru.gb.hockey_shop.service.CartService;
import ru.gb.hockey_shop.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class CartController {
    @Autowired
    private CartService cartService;



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

        model.addAttribute("cartProducts", listCartProduct);
        model.addAttribute("countPruductCart", count);
        model.addAttribute("summPriceProduct", summPriceProduct);

        return "cart";
    }

    @GetMapping("/cart-delete/{id}")
    public String deleteCartById(@PathVariable Long id) {
        cartService.deleteCartProduct(id);
        return "redirect:/cart";
    }


    // переносит продукт в карзину
    @PostMapping("/cart/{id}")
    public String addCartProduct(@PathVariable("id") Product product){
        cartService.createCartProduct(product);
        return "cart";
    }

    private Long countProductsCart(List<Cart> listCartProduct){
        Long count = cartService.getCartProducts().stream().count();
        return count;
    }

    private Integer summPriceProductsCart(List<Cart> listCartProduct){
        Integer summPrice = cartService.getCartProducts()
                .stream()
                .map(Cart::getCartPrice)
                .reduce(0, Integer::sum);
        return summPrice;
    }





}
