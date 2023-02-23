package com.abeera.shoppingcart.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abeera.shoppingcart.model.Productinfo;


public interface IProductinfoRepository extends JpaRepository <Productinfo, Long>{
    // public List<Productinfo> findAll();
    // public Optional<Productinfo> findById(Long id);
}

