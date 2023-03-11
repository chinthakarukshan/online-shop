package com.ecommerce.demo.onlineshop.service;

import com.ecommerce.demo.onlineshop.dto.Item;
import com.ecommerce.demo.onlineshop.dto.ShoppingCart;

import java.util.List;

public interface ShopItemService {

    List<Item> getItems();
}
