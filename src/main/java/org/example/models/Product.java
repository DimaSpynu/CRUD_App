package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Column(name = "name")
    private String name;
    @NotEmpty(message = "Description should not be empty")
    @Column(name = "description")
    private String description;
    @NotEmpty(message = "Price should not be empty")
    @Column(name = "price")
    private double price;
}
