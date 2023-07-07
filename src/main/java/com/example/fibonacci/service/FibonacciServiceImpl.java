package com.example.fibonacci.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class FibonacciServiceImpl implements FibonacciService{

    @Override
    public List<? extends Number> getNormalResult(int num){

        List<? extends Number> res;
        int start_0 = 0;
        int start_1 = 1;
        
        if(num < 50){  //For the first 50 numbers
            List<Long> longList = new ArrayList<>();

            longList.add(Long.valueOf(start_0));
            longList.add(Long.valueOf(start_1));
        
            //The first two already generated
            for(int i = 2; i <= num; i++){

                long tmp = longList.get(i-1) + longList.get(i-2);
                longList.add(tmp);

            }

            res = longList;
        }
        else{  //For big numbers

            List<BigInteger> BigList = new ArrayList<>();

            BigList.add(BigInteger.valueOf(start_0));
            BigList.add(BigInteger.valueOf(start_1));
        
            //The first two already generated
            for(int i = 2; i <= num; i++){

                BigInteger tmp = BigList.get(i-1).add(BigList.get(i-2));
                BigList.add(tmp);

            }

            res = BigList;
        }

        return res.subList(0, num);
    }


    @Override
    public <T extends Number> T[] getSortedResult(List<T> normalresult ){

            int sizeOfsres = normalresult.size();
            
            @SuppressWarnings("unchecked")
            T[] sres = (T[]) new Number[sizeOfsres];

            @SuppressWarnings("unchecked")
            T[] tmp = (T[]) new Number[sizeOfsres];
	        int index_e = 0;
	        int index_o = 0;

	        for(int i = 0; i < sizeOfsres; i++ ){
	        	
	            if(isEven(normalresult.get(sizeOfsres-1-i)))
	                sres[index_e++] = normalresult.get(sizeOfsres-1-i);
	            
	            else 
	                tmp[index_o++] = normalresult.get(sizeOfsres-1-i);
	        }

            System.arraycopy(tmp, 0, sres,index_e,index_o);



	        return sres;
    }

    private static boolean isEven(Number num) {

        if (num instanceof BigInteger) {

            BigInteger bigInteger = (BigInteger) num;
            return bigInteger.mod(BigInteger.TWO).equals(BigInteger.ZERO);
            
        } else if (num instanceof Long) {

            Long longValue = (Long) num;
            return longValue % 2 == 0;

        }

        throw new IllegalArgumentException("Unsupported number type");
    }
    
}
