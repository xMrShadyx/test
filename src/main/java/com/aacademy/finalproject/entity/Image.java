package com.aacademy.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="dish_id", foreignKey = @ForeignKey(name = "fk_dish_id"))
    private Dish dish;


}
