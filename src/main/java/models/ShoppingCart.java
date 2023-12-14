package models;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<Integer, CartProduct> shoppingCartMap;

    public ShoppingCart() {
        shoppingCartMap = new HashMap<>();
    }

    public HashMap<Integer, CartProduct> getShoppingCartMap() {
        return shoppingCartMap;
    }

    public void setShoppingCartMap(HashMap<Integer, CartProduct> shoppingCartMap) {
        this.shoppingCartMap = shoppingCartMap;
    }
}
