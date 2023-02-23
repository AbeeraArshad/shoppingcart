package com.abeera.shoppingcart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abeera.shoppingcart.Repository.IProductinfoRepository;
import com.abeera.shoppingcart.Service.ProductService;
import com.abeera.shoppingcart.model.Productinfo;

@SpringBootTest
class ShoppingcartApplicationTests {

	
	@Mock
	private IProductinfoRepository iProductinfoRepository;

    @InjectMocks
	private ProductService productService;
	@Test
	void contextLoads() {
	}
	@Test
	void getAndSetID(){
    Productinfo cut = new Productinfo();
	Long myId = 1L;
	cut.setId(myId);
	assertEquals(myId,cut.getId());
	}
	@Test
	void getAndSetName(){
		Productinfo cut = new Productinfo();
		String myproductname = "rubby";
		cut.setName(myproductname);
		assertEquals(myproductname, cut.getName());
	}
	@Test
	void getAndSetshortDescription(){
		Productinfo cut = new Productinfo();
		String myDescription = "rubby";
		cut.setShortDescription(myDescription);
		assertEquals(myDescription, cut.getShortDescription());
	}

	@Test
	void getAndSetlongDescription(){
		Productinfo cut = new Productinfo();
		String myDescript = "i LIKE RUBBY";
		cut.setLongDescription(myDescript);
		assertEquals(myDescript, cut.getLongDescription());

	
	}

    @Test
	void getAndSetprice(){
		Productinfo cut = new Productinfo();
		Long productPrice = 30L;
		cut.setPrice(productPrice);
		assertEquals(productPrice, cut.getPrice());

	
	}
}
