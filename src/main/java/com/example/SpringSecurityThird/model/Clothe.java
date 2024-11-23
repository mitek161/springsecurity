package com.example.SpringSecurityThird.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Clothe")
@Getter
@Setter
@NoArgsConstructor
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private int price;
    @Column(name = "color")
    private String color;

    public Clothe(String category, int price, String color) {
        this.category = category;
        this.price = price;
        this.color = color;
    }
}
