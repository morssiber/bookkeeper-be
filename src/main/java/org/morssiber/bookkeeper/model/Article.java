package org.morssiber.bookkeeper.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String name;

    private String brand;

    private String shop;

    private String unit;

    private double pricePerUnit;

    private double totalPrice;

    private boolean deal;
}
