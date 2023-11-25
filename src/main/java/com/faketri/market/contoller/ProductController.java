package com.faketri.market.contoller;


import com.faketri.market.entity.Product;
import com.faketri.market.service.BrandService;
import com.faketri.market.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController()
@RequestMapping("/api/product")
@Tag(name = "Product", description = "Operation with product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    @RequestMapping(path = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Product> getAllProduct(){
        return productService.findAll();
    }

    @RequestMapping(path = "/page",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Page<Product> getAllByPages(
            @RequestParam("number") Integer page_number,
            @RequestParam("size") Integer page_size){
        return productService.findAll(PageRequest.of(page_number, page_size));
    }

    @RequestMapping(path = "/{productId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Product getProduct(@PathVariable(value = "productId") Long productId){
        return productService.findById(productId);
    }
}
