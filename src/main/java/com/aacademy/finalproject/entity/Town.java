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
@Table(name = "towns")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany
    @JoinTable(
            name = "towns_restaurants",
            joinColumns = @JoinColumn(name = "town_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id")
    )
    private Set<Restaurant> restaurants;

    @OneToMany
    @JoinTable(
            name = "towns_neighborhoods",
            joinColumns = @JoinColumn(name = "town_id"),
            inverseJoinColumns = @JoinColumn(name = "neighborhoods_id")
    )
    private Set<Neighborhood> neighborhoods;
}
