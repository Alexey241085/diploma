package ru.gb.hockey_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.hockey_shop.model.product.Product;
import ru.gb.hockey_shop.service.CartService;
import ru.gb.hockey_shop.service.ProductService;

@Controller
@AllArgsConstructor
public class CartController {
    @Autowired
    private CartService cartService;



    @GetMapping("/cart")
    public String showCartProduct(){
        cartService.getCartProducts();
        return "cart";
    }


    // переносит продукт в карзину
    @PostMapping("/cart/{id}")
    public String addCartProduct(@PathVariable("id") Product product){
        cartService.createCartProduct(product);
        return "cart";
    }





}
