package com.ecommerce.demo.onlineshop.controller;

import com.ecommerce.demo.onlineshop.dto.Item;
import com.ecommerce.demo.onlineshop.dto.ShoppingCart;
import com.ecommerce.demo.onlineshop.service.OnlineShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onlineshop")
public class OnlineShopController {

    @Autowired
    OnlineShopService onlineShopService;

    @GetMapping(path = "/items")
    public List<Item> getItems() {
        return onlineShopService.getItems();
    }

    @GetMapping("/cart")
    public ShoppingCart getShoppingCart() {
        return onlineShopService.getShoppingCart();
    }


}
