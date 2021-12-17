package com.aacademy.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "dish_id" , foreignKey = @ForeignKey(name = "fk_dish_id"))
    private Dish dish;
/*
    @ManyToMany(mappedBy = "restaurants")
    private Set<Town> towns;


 */
    @ManyToMany(mappedBy = "restaurants")
    private Set<Neighborhood> neighborhoods;

    @ManyToMany
    private Set<Dish> dishes;







}
