package com.ecommerce.demo.onlineshop.controller;

import com.ecommerce.demo.onlineshop.dto.Item;
import com.ecommerce.demo.onlineshop.service.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ShopItemController {

    @Autowired
    ShopItemService shopItemService;

    public List<Item> getItems() {
        return shopItemService.getItems();
    }


}
