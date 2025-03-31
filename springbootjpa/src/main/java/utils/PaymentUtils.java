package utils;

import java.util.HashMap;
import java.util.Map;

import Exception.InsufficientAmountPaidException;

public class PaymentUtils {
    
    private static Map<String , Double> paymentMap = new HashMap<>();

   static {
        paymentMap.put("acc1", 12000.0);
        paymentMap.put("acc2", 11000.0);
        paymentMap.put("acc3", 10000.0); 
        paymentMap.put("acc4", 8000.0);
    }


    public static boolean validateCredentials(String AccNo , double paidAmount){


        if(paymentMap.get(AccNo) > paidAmount){
            return true;
        }else{
            throw new InsufficientAmountPaidException("Insufficeint fund in the account "+ AccNo);
        }

    } 
}
