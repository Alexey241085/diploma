package ru.gb.hockey_shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hockey_shop.model.product.Cart;
import ru.gb.hockey_shop.model.product.Product;
import ru.gb.hockey_shop.repository.CartRepository;
import ru.gb.hockey_shop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;


    // показать все из карзины
    public List<Cart> getCartProducts(){
        return cartRepository.findAll();
    }

    // создать продукт в карзине ( администратор)
    public void createCartProduct(Product product){
        Cart cartProduct = new Cart();
        cartProduct.setCartName(product.getName());
        cartProduct.setCartImage(product.getImage());
        cartProduct.setCartBrand(product.getBrand());
        cartProduct.setCartPrice(product.getPrice());
        cartProduct.setCartSize(product.getSize());
        cartProduct.setCartTitle(product.getTitle());
        cartRepository.save(cartProduct);
    }

    // Удалить продукт из карзины
    public void deleteCartProduct(Long id){
        cartRepository.deleteById(id);
    }


    // изменить продукт (администратор)
//    public Product updateProduct(Long id, Product updateProduct){
//        Optional<Product> optionalProduct = productRepository.findById(id);
//        if (optionalProduct.isPresent()) {
//            Product product = optionalProduct.get();
//            product.setName(updateProduct.getName());
//            product.setSize(updateProduct.getSize());
//            product.setBrand(product.getBrand());
//            product.setImage(product.getImage());
//            return productRepository.save(product);
//        } else {
//            throw new IllegalArgumentException("Product not found with id: " + id);
//        }
//    }

}
