package com.abeera.shoppingcart;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.abeera.shoppingcart.Controller.ProductController;
import com.abeera.shoppingcart.model.Productinfo;
import com.abeera.shoppingcart.Service.ProductService;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc

public class ProductControllerTests {
    private MockMvc mvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController controller;
    private JacksonTester<Productinfo> json;
	private JacksonTester<Collection<Productinfo>> jsonList;

    @BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

    @Test
    void contextLoads() {
     }

     @Test
    public void getProductById() throws Exception{
        Productinfo info = new Productinfo(1L,"RUBBY",
        "i Like rubby","i like rubbby it is a good stone",
        "https://fsghfgfyhcghh", 23L);

		when(productService.get_product_by_id(1L)).thenReturn(info);
		mvc.perform(get("/api/product_list/1")
		.contentType(MediaType.APPLICATION_JSON)
		.content(json.write(info).getJson()))
		.andExpect(status().isOk())
		.andExpect(content().json(json.write(info).getJson()));
}
@Test
public void canCreateProductinfo() throws Exception {
    Productinfo info1 = new Productinfo(1L,"RUBBY",
    "i Like rubby","i like rubbby it is a good stone",
    "https://fsghfgfyhcghh", 23L);
    when(productService.create(info1)).thenReturn(info1);
    mvc.perform(post("/api/product_list")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json.write(info1).getJson()))
            .andExpect(status().isCreated());

}
@Test
	public void canGetAllProductInfo() throws Exception {
		Productinfo info1 = new Productinfo(1L,"RUBBY",
        "i Like rubby","i like rubbby it is a good stone",
        "https://fsghfgfyhcghh", 23L);
		Productinfo info2 = new Productinfo(2L,"bronze",
        "i Like rubby","i like bronze it is a good stone",
        "https://fsghfgfyhcghh", 23L);
		List<Productinfo> productinfo = new ArrayList<Productinfo>();
		productinfo.add(info1);
		productinfo.add(info2);
		when(productService.get_all_products()).thenReturn(productinfo);
		mvc.perform(get("/api/product_list/all")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonList.write(productinfo).getJson()));

}
}
// @Test
// public void canDeleteCandidateAcademicInfo() throws Exception {
//     Productinfo info = new Productinfo(2L,"bronze",
//     "i Like rubby","i like bronze it is a good stone",
//     "https://fsghfgfyhcghh", 23L);
//     when(productService.delete(null)).thenReturn(info);
//     mvc.perform(delete("/api/product_list/2"))
//         .andExpect(status().isNoContent());
// }
// }
