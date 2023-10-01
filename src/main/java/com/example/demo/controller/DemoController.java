package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
@Validated
public class DemoController {

    private final ProductService productService;

    @Autowired
    public DemoController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String demo() {
        return "Hello";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void postDemo(@RequestBody @Valid ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @GetMapping("/{id}")
    public ProductEntity getById(@PathVariable("id") @PositiveOrZero Integer id) {
        return productService.findById(id);
    }

}
