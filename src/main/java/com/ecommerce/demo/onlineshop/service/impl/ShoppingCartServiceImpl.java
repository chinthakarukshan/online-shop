package com.ecommerce.demo.onlineshop.service.impl;

import com.ecommerce.demo.onlineshop.dto.Item;
import com.ecommerce.demo.onlineshop.dto.ShoppingCart;
import com.ecommerce.demo.onlineshop.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    static Item book;
    static Item toy;
    static Item lamp;

    ShoppingCart shoppingCart;

    static {
        book = new Item();
        book.setId(1);
        book.setCategory("Book");
        book.setItemCode("BOOK-0001");
        book.setPrice(new BigDecimal(670));
        book.setItemName("The Perception Myth");

        toy = new Item();
        toy.setId(1);
        toy.setCategory("Toys");
        toy.setItemCode("TOY-0010");
        toy.setPrice(new BigDecimal(1500));
        toy.setItemName("Remote Car");

        lamp = new Item();
        lamp.setId(1);
        lamp.setCategory("Toys");
        lamp.setItemCode("TOY-0010");
        lamp.setPrice(new BigDecimal(1500));
        lamp.setItemName("Remote Car");
    }

    @Override
    public ShoppingCart getShoppingCart() {
        ShoppingCart myShoppingCart = new ShoppingCart();
        List<Item> cartItems = new ArrayList<>();
        cartItems.add(toy);

        shoppingCart.setCartId(12);
        shoppingCart.setCartItems(cartItems);

        return shoppingCart;
    }
}
