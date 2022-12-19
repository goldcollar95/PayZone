package com.example.ecommerce.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ecommercedb")
@Table(name= "ecommercedb")
@Setter
@Getter
public class CrudEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;

}
