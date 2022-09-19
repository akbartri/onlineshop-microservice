package com.akbar.onlineshop.product.util;

import com.akbar.onlineshop.commons.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductUtil {
    public static List<ProductDto> dummys() {
        List<ProductDto> result = new ArrayList<>();
        ProductDto productDto1 = new ProductDto();
        productDto1.setId("1");
        productDto1.setProductName("Fanta");
        productDto1.setPrice(5000);
        productDto1.setDescription("Minuman Soda Enak");
        productDto1.setStock(999);
        productDto1.setStatus("ACTIVE");
        result.add(productDto1);

        ProductDto productDto2 = new ProductDto();
        productDto2.setId("2");
        productDto2.setProductName("Mie Gelas");
        productDto2.setPrice(500);
        productDto2.setDescription("Mie Instan yang enggak pake ribet");
        productDto2.setStock(999);
        productDto2.setStatus("ACTIVE");
        result.add(productDto2);

        return result;
    }
}
