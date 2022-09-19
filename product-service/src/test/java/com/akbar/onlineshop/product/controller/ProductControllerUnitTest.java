package com.akbar.onlineshop.product.controller;

import com.akbar.onlineshop.commons.dto.ProductDto;
import com.akbar.onlineshop.commons.dto.ResponseDto;
import com.akbar.onlineshop.product.service.ProductService;
import com.akbar.onlineshop.product.util.ProductUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductControllerUnitTest {

    @Test
    void getAllProducts() {
        List<ProductDto> dummys = ProductUtil.dummys();
        ProductService productService = Mockito.mock(ProductService.class);
        when(productService.getAllProducts()).thenReturn(dummys);
        ProductController productController = new ProductController(productService);

        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("0");
        responseDto.setMessage("Success");
        responseDto.setContents(dummys);

        ResponseEntity<?> responseEntity = new ResponseEntity<>(
                responseDto,
                HttpStatus.OK
        );

        assertEquals(responseEntity,productController.getAllProducts());
    }
}