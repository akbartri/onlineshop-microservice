package com.akbar.onlineshop.product.controller;

import com.akbar.onlineshop.commons.dto.ProductDto;
import com.akbar.onlineshop.commons.dto.ResponseDto;
import com.akbar.onlineshop.product.service.ProductService;
import com.akbar.onlineshop.product.util.ProductUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void getAllProducts() throws Exception {
        List<ProductDto> dummys = ProductUtil.dummys();
        ObjectWriter ow = new ObjectMapper().writerWithDefaultPrettyPrinter();

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("0");
        responseDto.setMessage("Success");
        responseDto.setContents(dummys);

        when(productService.getAllProducts()).thenReturn(dummys);
        mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(ow.writeValueAsString(responseDto)));
        verify(productService).getAllProducts();
    }
}