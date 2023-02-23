package com.abeera.shoppingcart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abeera.shoppingcart.model.Productinfo;
import com.abeera.shoppingcart.Repository.IProductinfoRepository;

@Service
public class ProductService {

    @Autowired
    public IProductinfoRepository repo;

    public  Productinfo create(Productinfo product){
        return repo.save(product);
    }

    public Productinfo get_product_by_id(Long id){
        return repo.findById(id).orElse(null);
    }

    public List<Productinfo> get_all_products(){
        return repo.findAll();
    }


    public Productinfo updateProductInformation(Long id, Productinfo productInformation){
        Optional<Productinfo> productOptional = repo.findById(id);
           if(productOptional.isPresent()){
            Productinfo existingProductInformation =  productOptional.get();
            existingProductInformation.setId(productInformation.getId());
            existingProductInformation.setName(productInformation.getName());
            existingProductInformation.setShortDescription(productInformation.getShortDescription());
            existingProductInformation.setLongDescription(productInformation.getLongDescription());
            existingProductInformation.setImage_Link(productInformation.getImage_Link());
            existingProductInformation.setPrice(productInformation.getPrice());
            
            repo.save(existingProductInformation);
            return existingProductInformation;
        }
        else{
            return null;
        }
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    
}
