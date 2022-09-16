package com.akbar.onlineshop.product.controller;

import com.akbar.onlineshop.commons.dto.ProductDto;
import com.akbar.onlineshop.commons.dto.ResponseDto;
import com.akbar.onlineshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("1");
        responseDto.setMessage("Error");

        List<ProductDto> productDtoList = productService.getAllProducts();
        HttpStatus status = HttpStatus.NOT_FOUND;

        if(productDtoList.size() > 0) {
            responseDto.setStatus("0");
            responseDto.setMessage("Success");
            responseDto.setContents(productDtoList);
            status = HttpStatus.OK;
        }

        return new ResponseEntity<>(responseDto, status);
    }
}
