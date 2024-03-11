package com.wipro.designpatterns.strategy;

public class StrategyImpl {
    public static void main(String[] args) {

        CartPage cartPage = new CartPage();

        Item item1 = new Item("1234", 250);
        Item item2 = new Item("3651", 680);

        cartPage.addItem(item1);
        cartPage.addItem(item2);

        // paypal payment
        cartPage.pay(new PaypalPayment("dattasai.vadapalli@wipro.com", "password"));

        // card payment
        cartPage.pay(new CardPayment("Datta Sai", "1234567890123456","263", "12/36"));



    }
}