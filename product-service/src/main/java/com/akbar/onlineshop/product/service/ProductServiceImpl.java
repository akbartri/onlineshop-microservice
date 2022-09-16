package com.akbar.onlineshop.product.service;

import com.akbar.onlineshop.commons.dto.ProductDto;
import com.akbar.onlineshop.product.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(product -> {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            return productDto;
        }).collect(Collectors.toList());
    }
}
