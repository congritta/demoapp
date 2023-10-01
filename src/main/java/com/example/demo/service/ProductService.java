package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setOption(productDto.getOption());
        productRepository.save(productEntity);
    }

    public ProductEntity findById(Integer id) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElseThrow(() -> {
                    log.error("Entity not found");
                    throw new EntityNotFoundException("Not found");
                }
        );
    }

}
