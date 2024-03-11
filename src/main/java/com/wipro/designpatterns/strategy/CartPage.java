package com.wipro.designpatterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    List<Item> itemList;

    public CartPage() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Item item : itemList) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay(PaymentGatewayInterface paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }


}
