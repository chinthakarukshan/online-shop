package com.ecommerce.demo.onlineshop.controller;

import com.ecommerce.demo.onlineshop.dto.ShoppingCart;
import com.ecommerce.demo.onlineshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping
    public ShoppingCart getShoppingCart() {
        return shoppingCartService.getShoppingCart();
    }
}
