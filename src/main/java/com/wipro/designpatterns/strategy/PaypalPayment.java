package com.wipro.designpatterns.strategy;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
@Getter
public class PaypalPayment implements PaymentGatewayInterface{

    Logger log = LoggerFactory.getLogger(PaypalPayment.class);


    private String emailId;
    private String password;

    public PaypalPayment(String email, String pwd){
        this.emailId=email;
        this.password=pwd;
    }

    @Override
    public void pay(int amount) {
        log.info("{} paid using Paypal.",amount);
    }
}
