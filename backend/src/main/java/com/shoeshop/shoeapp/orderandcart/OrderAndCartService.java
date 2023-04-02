package com.shoeshop.shoeapp.orderandcart;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoeshop.shoeapp.product.Product;
import com.shoeshop.shoeapp.product.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderAndCartService {
    private final OrderAndCartRepository orderAndCartRepository;
    private final ProductRepository productRepository;

    public void addCart(OrderAndCart orderAndCart) {
        orderAndCartRepository.save(orderAndCart);
    }

    public void order(String userId) {
        var<OrderAndCart> carts = orderAndCartRepository.findAllByUserIdAndStatus(userId, 0);

        for (OrderAndCart orderAndCart : carts) {
            orderAndCart.setStatus(1);
        }

        orderAndCartRepository.saveAll(carts);
    }

    public List<Product> getCarts(String userId) {
        var<OrderAndCart> carts = orderAndCartRepository.findAllByUserIdAndStatus(userId, 0);

        var<String> prodcutIds = carts
                .stream()
                .map(cart -> new String(cart.getProductId())).toList();
        return productRepository.getProductsIn(prodcutIds);
    }

    public List<Product> getOrders(String userId) {
        var<OrderAndCart> carts = orderAndCartRepository.findAllByUserIdAndStatus(userId, 1);

        var<String> prodcutIds = carts
                .stream()
                .map(cart -> new String(cart.getProductId())).toList();
        return productRepository.getProductsIn(prodcutIds);
    }

    public void removeProduct(String userId, String productId) {
        orderAndCartRepository.deleteByUserIdAndProductId(userId, productId);
    }
}
