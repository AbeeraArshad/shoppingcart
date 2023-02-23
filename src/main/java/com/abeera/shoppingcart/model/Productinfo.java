package com.abeera.shoppingcart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="product")

public class Productinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long id;

      @Column(nullable = false)
      private String name;

      @Column(columnDefinition ="TEXT",nullable = false)
      private String shortDescription;

      @Column(columnDefinition ="TEXT",nullable = false)
      private String longDescription;

      @Lob
      @Column(columnDefinition ="TEXT",nullable = false)
      private String image_Link;

      @Column(nullable = false)
      private Long price;
      
       public Productinfo(Long id, String name, String shortDescrption, String longDescription, String image_Link, Long price) {
         this.id = id;
         this.name = name;
         this.shortDescription= shortDescrption;
         this.longDescription = longDescription;
         this.image_Link = image_Link;
         this.price=price;
     }
    
}
