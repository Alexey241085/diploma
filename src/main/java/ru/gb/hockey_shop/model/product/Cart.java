package ru.gb.hockey_shop.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String cartName;
    @Column(name = "size", nullable = false)
    private Double cartSize;
    @Column(name = "brand", nullable = false)
    private String cartBrand;
    @Column(name = "price", nullable = false)
    private Integer cartPrice;
    @Column(name = "title")
    private String cartTitle;
    @Column(name = "image")
    private String cartImage;
    @Column(name ="idUser")
    private String personName;

}
