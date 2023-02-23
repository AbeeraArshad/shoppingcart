package com.abeera.shoppingcart.Controller;

    
    import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abeera.shoppingcart.model.Productinfo;
import com.abeera.shoppingcart.Service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/product_list")
public class ProductController {

   @Autowired
    public ProductService service;

    @PostMapping("")
    public ResponseEntity<Productinfo> createPrdList(
        @RequestBody Productinfo prdList){
         Productinfo productCreated = service.create(prdList); 
         return new ResponseEntity<>(productCreated,HttpStatus.CREATED);
        }

     @GetMapping("/all")
     public List<Productinfo>get_product(){
        return service.get_all_products();
     }

     @GetMapping("/{id}")
    public ResponseEntity<Productinfo> getProductById(@PathVariable Long id) {
        Productinfo value = service.get_product_by_id(id);
        if (value == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Productinfo>(value, HttpStatus.OK);
    }
     
    //  @PutMapping("/update_product")
    //     public ResponseEntity<Productinfo> updatePrdList(@PathVariable Long id,
    //             @RequestBody Productinfo prdctinformation) {
    //                 Productinfo updatedProductInformation = service.updateProductInformation(id,
    //                 prdctinformation);
    //         if (updatedProductInformation == null) {
    //             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
    //         } else {
    //             return new ResponseEntity<Productinfo>(updatedProductInformation, HttpStatus.OK);
    //         }
    //     }


     @DeleteMapping("/delete_product/{id}")
     public ResponseEntity post_product (@PathVariable Long id){
 
         service.delete(id);
         return new ResponseEntity<Object>("Product Deleted Successfully" ,HttpStatus.OK); 

     }

     



    
    
}

