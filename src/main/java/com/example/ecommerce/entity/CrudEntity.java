package com.example.ecommerce.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="sample_member")
@Table(name= "sample_member")
@Setter
@Getter
public class CrudEntity {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int age;

}
