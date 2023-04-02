package com.shoeshop.shoeapp.orderandcart;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoeshop.shoeapp.product.Product;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orderandcart")
@RequiredArgsConstructor
public class OrderAndCartController {
    private final OrderAndCartService orderAndCartService;

    @PostMapping("/cart")
    public void addCart(@RequestBody OrderAndCartDtoRequest dtoRequest) {
        var orderAndCart = new OrderAndCart();
        BeanUtils.copyProperties(dtoRequest, orderAndCart);
        orderAndCartService.addCart(orderAndCart);
    }

    @GetMapping("/order/{userId}")
    public void order(@PathVariable String userId) {
        orderAndCartService.order(userId);
    }

    @GetMapping("/cart/all/{userId}")
    public List<Product> getAllCart(@PathVariable String userId) {
        return orderAndCartService.getCarts(userId);
    }

    @GetMapping("/order/all/{userId}")
    public List<Product> getAllOrder(@PathVariable String userId) {
        return orderAndCartService.getOrders(userId);
    }

    @DeleteMapping("/cart/{userId}/{productId}")
    public void removeCart(String userId, String productId) {
        orderAndCartService.removeProduct(userId, productId);
    }

}
