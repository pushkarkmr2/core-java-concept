package com.wipro.designpatterns.strategy;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
@Getter
public class CardPayment implements PaymentGatewayInterface {

    Logger log = LoggerFactory.getLogger(CardPayment.class);


    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CardPayment(String name, String cardNumber, String cvv, String expiryDate) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount) {
        log.info("{} paid with credit/debit card", amount);
    }
}
