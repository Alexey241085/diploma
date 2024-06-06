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
import ru.gb.hockey_shop.service.PersonService;
import ru.gb.hockey_shop.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PersonService personService;

    // показывает главную страницу
    @GetMapping
    public String welcome() {
        return "index";
    }

    @GetMapping("/catalog/{id}")
    public String showById(@PathVariable("id") Long id){
       productService.getProductById(id);
       return "";
    }

    @GetMapping("/catalog")
    public String showCatalog(){
        return "catalog";
    }



    // показывает список к
    @GetMapping("catalog/list-skates")
    public String showProduct(Model model) {
        String s = "коньки";
        List<Product> listProduct = productService.getProducts();
        List<Product> listProduct2 = listProduct.stream().filter(skate->skate.getName().equals(s)).collect(Collectors.toList());
        model.addAttribute("products", listProduct2);
        return "list-skates";
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

    @PostMapping("/admin")
    public String creatProduct (@ModelAttribute("product") Product product){
        productService.createProduct(product);
        return "admin";
    }

    @GetMapping("/admin-delete/{id}")
    public String deleteById(@PathVariable Long id){
        productService.deleteProduct(id);
        return"redirect:/admin";
    }

    @GetMapping("/update-product/{id}")
    public String updateUser(Product product){
        return "update-product";
    }


    @PostMapping("/update-product")
    public String updateProduct(Product product, Long id){
        productService.updateProduct(id, product);
        return "admin";
    }



//    @GetMapping("/admin-creat")
//    public String adminCreat(Model model){
//        model.addAttribute("product", new Product());
//        return "admin-creat";
//    }


}


