package com.gud.noderflow.core;


import java.math.BigDecimal;

public class MoneyTransactionValidator {


    public static boolean isBalanceGreaterThanWithdrawAmount(BigDecimal userBalance , BigDecimal withdrawAmount){
        return userBalance.compareTo(withdrawAmount) >= 0;
    }
}
