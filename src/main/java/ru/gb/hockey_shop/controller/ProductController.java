package ru.gb.hockey_shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.hockey_shop.model.Person;
import ru.gb.hockey_shop.model.product.Product;
import ru.gb.hockey_shop.repository.PersonRepository;
import ru.gb.hockey_shop.service.CartService;
import ru.gb.hockey_shop.service.PersonService;
import ru.gb.hockey_shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PersonService personService;
    @Autowired
    private CartService cartService;

    // показывает главную страницу
    @GetMapping
    public String welcome() {
        return "index";
    }


    @GetMapping("/catalog")
    public String showCatalog() {
        return "catalog";
    }


    // показывает список - коньки
    @GetMapping("/catalog/list-skates")
    public String showProductSkates(Model model) {
        String s = "коньки";
        List<Product> listProduct = productService.getProducts();
        List<Product> listProduct2 = listProduct.stream()
                .filter(skate -> skate.getName().equals(s))
                .collect(Collectors.toList());
        model.addAttribute("products", listProduct2);
        return "list-skates";
    }

    @GetMapping("/catalog/list-skate-cart/{id}")
    public String creatCartProductSkate(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        cartService.createCartProduct(product);
        return "redirect:/catalog/list-skates";
    }


    // показывает список - шорты
    @GetMapping("/catalog/list-shorts")
    public String showProductShorts(Model model) {
        String s = "шорты";
        List<Product> listProduct = productService.getProducts();
        List<Product> listProduct2 = listProduct.stream()
                .filter(skate -> skate.getName().equals(s))
                .collect(Collectors.toList());
        model.addAttribute("products", listProduct2);
        return "list-shorts";
    }

    @GetMapping("/catalog/list-shorts-cart/{id}")
    public String creatCartProductShorts(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        cartService.createCartProduct(product);
        return "redirect:/catalog/list-shorts";
    }


    // показывает список - щитки
    @GetMapping("/catalog/list-shields")
    public String showProductShields(Model model) {
        String s = "щитки";
        List<Product> listProduct = productService.getProducts();
        List<Product> listProduct2 = listProduct.stream()
                .filter(skate -> skate.getName().equals(s))
                .collect(Collectors.toList());
        model.addAttribute("products", listProduct2);
        return "list-shields";
    }

    @GetMapping("/catalog/list-shields-cart/{id}")
    public String creatCartProductShields(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        cartService.createCartProduct(product);
        return "redirect:/catalog/list-shields";
    }


    // показывает список - клюшка
    @GetMapping("/catalog/list-stick")
    public String showProductStick(Model model) {
        String s = "клюшка";
        List<Product> listProduct = productService.getProducts();
        List<Product> listProduct2 = listProduct.stream()
                .filter(skate -> skate.getName().equals(s))
                .collect(Collectors.toList());
        model.addAttribute("products", listProduct2);
        return "list-stick";
    }

    @GetMapping("/catalog/list-stick-cart/{id}")
    public String creatCartProductStick(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        cartService.createCartProduct(product);
        return "redirect:/catalog/list-stick";
    }


    // показывает список - шлем
    @GetMapping("/catalog/list-helmet")
    public String showProductHelmet(Model model) {
        String s = "шлем";
        List<Product> listProduct = productService.getProducts();
        List<Product> listProduct2 = listProduct.stream()
                .filter(skate -> skate.getName().equals(s))
                .collect(Collectors.toList());
        model.addAttribute("products", listProduct2);
        return "list-helmet";
    }

    @GetMapping("/catalog/list-helmet-cart/{id}")
    public String creatCartProductHelmet(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        cartService.createCartProduct(product);
        return "redirect:/catalog/list-helmet";
    }


    // показывает список - локти
    @GetMapping("/catalog/list-leggings")
    public String showProductLeggings(Model model) {
        String s = "краги";
        List<Product> listProduct = productService.getProducts();
        List<Product> listProduct2 = listProduct.stream()
                .filter(skate -> skate.getName().equals(s))
                .collect(Collectors.toList());
        model.addAttribute("products", listProduct2);
        return "list-leggings";
    }

    @GetMapping("/catalog/list-leggings-cart/{id}")
    public String creatCartProductLeggings(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        cartService.createCartProduct(product);
        return "redirect:/catalog/list-leggings";
    }


    // показывает список - нагрудник
    @GetMapping("/catalog/list-bib")
    public String showProductBib(Model model) {
        String s = "нагрудник";
        List<Product> listProduct = productService.getProducts();
        List<Product> listProduct2 = listProduct.stream()
                .filter(skate -> skate.getName().equals(s))
                .collect(Collectors.toList());
        model.addAttribute("products", listProduct2);
        return "list-bib";
    }

    @GetMapping("/catalog/list-bib-cart/{id}")
    public String creatCartProducBib(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        cartService.createCartProduct(product);
        return "redirect:/catalog/list-bib";
    }


    // показывает список - налокотники
    @GetMapping("/catalog/list-elbows")
    public String showProductElbows(Model model) {
        String s = "налокотники";
        List<Product> listProduct = productService.getProducts();
        List<Product> listProduct2 = listProduct.stream()
                .filter(skate -> skate.getName().equals(s))
                .collect(Collectors.toList());
        model.addAttribute("products", listProduct2);
        return "list-elbows";
    }

    @GetMapping("/catalog/list-elbows-cart/{id}")
    public String creatCartProductElbows(@PathVariable Long id) {
        Product product = productService.getProductById(id).get();
        cartService.createCartProduct(product);
        return "redirect:/catalog/list-elbows";
    }


    // показывает страницу about
    @GetMapping("/about")
    public String about() {
        return "about";
    }


    // показывает страницу аутентификации
    @GetMapping("/auth")
    public String auth() {
        return "auth";
    }


    // показывает страницу admin
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin(Model model) {
        List<Person> personList = personService.getPerson();
        List<Product> allproducts = productService.getProducts();
        model.addAttribute("persons", personList);
        model.addAttribute("product", new Product());
        model.addAttribute("all_products", allproducts);
        return "admin";
    }

    // страница /admin создание продукта(product) и добавление к БД
    @PostMapping("/admin")
    public String creatProductAdmin(@ModelAttribute("product") Product product) {
        productService.createProduct(product);
        return "redirect:/admin";
    }

    // удаление продукта из БД страница /admin
    @GetMapping("/admin-delete/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin";
    }


    // страница открывается когда необходимо изменить продукт(product)
    @GetMapping("/update-product/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id).get());
        return "update-product";
    }

    @PostMapping("/update-product/{id}")
    public String updateProduct(@PathVariable Long id, Product product) {
        productService.updateProduct(id, product);
        System.out.println(product);
        return "redirect:/admin";
    }


}








