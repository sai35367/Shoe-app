package com.shoeshop.shoeapp.product;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        if (product != null || product.getProductId().isEmpty())
            product.setProductId(null);
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }
}
