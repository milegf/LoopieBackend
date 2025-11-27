package com.example.loopie.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Arrays;

import com.example.loopie.Users.service.UserService;
import com.example.loopie.Products.controller.ProductController;
import com.example.loopie.Products.model.Product;
import com.example.loopie.Products.service.ProductService;
import com.example.loopie.Users.controller.UserController;
import com.example.loopie.Users.dto.User;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService servicio;

    @Test
    public void testGetAllProducts()throws Exception {
        Product product1 = new Product(1, "Chaqueta Vintage", "Chaqueta de cuero estilo vintage, forro interior acolchado", 129.99, "Abrigo", 12, "https://cdn.example.com/products/chaqueta_vintage.jpg", true, 99.99, "VintageStore", "L", "vintage,cuero,otoño", true);
        Product product2 = new Product(2, "Zapatos Deportivos", "Zapatos deportivos ligeros y transpirables para correr", 89.99, "Calzado", 30, "https://cdn.example.com/products/zapatos_deportivos.jpg", true, 69.99, "Sporty", "42", "deporte,correr,ligero", true);

        when(servicio.getAllProducts()).thenReturn(Arrays.asList(product1, product2));

        mockMvc.perform(get("/api/v1/products"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].name").value("Chaqueta Vintage"))
               .andExpect(jsonPath("$[1].name").value("Zapatos Deportivos"));
    }

}

