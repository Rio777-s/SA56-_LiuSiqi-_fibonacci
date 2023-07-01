package com.example.fibonacci.service;

import java.util.*;

public interface FibonacciService {

    //Compute Fibonacci Sequence
    public List<? extends Number> getNormalResult(int num );

    //Sort Fibonacci Sequence
    public <T extends Number> T[] getSortedResult(List<T> normalresult );
}
