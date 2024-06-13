package ru.gb.hockey_shop.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.hockey_shop.model.product.Product;
import ru.gb.hockey_shop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    // показать все продукты
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    // создать продукт ( администратор)
    public void createProduct(Product product){
        productRepository.save(product);
    }

    // Удалить продукт (администратор)
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }


    // изменить продукт (администратор)
    public Product updateProduct(Long id, Product updateProduct){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(updateProduct.getName());
            product.setSize(updateProduct.getSize());
            product.setBrand(updateProduct.getBrand());
            product.setImage(updateProduct.getImage());
            product.setPrice(updateProduct.getPrice());
            product.setTitle(updateProduct.getTitle());
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
    }
}

