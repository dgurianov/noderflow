package com.gud.noderflow.util.fabricator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentDataFabricator {

    private Random rand = new Random();
    private int counter = 0;


    public String getAccountNumber(){
        this.counter += 1;
        return String.format("%012d",this.counter);
    }

    public double getAccountBalance(){
        return rand.nextInt(100000);
    }

    public double getAccountTopUpAmount(){
        return rand.nextInt(500);
    }
    public Long getNextTimeToTheNextTopUp(){
            return rand.nextLong();
    }

    public int getTopUpFrequency(){
            return rand.nextInt(50);
    }


}
