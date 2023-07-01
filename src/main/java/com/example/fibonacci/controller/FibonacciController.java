package com.example.fibonacci.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fibonacci.service.FibonacciService;

@CrossOrigin() //Allow cross-domain requests
@RestController
@RequestMapping("fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

   @PostMapping
    public ResponseEntity<Map<String, List<? extends Number>>> computeFibonacci(@RequestBody Map<String, Integer> request) {
        int num = request.getOrDefault("elements", 0);
        List<? extends Number> normalResult = fibonacciService.getNormalResult(num);
        Number[] sortedNumbers = fibonacciService.getSortedResult(normalResult);

        Map<String, List<? extends Number>> response = new HashMap<>();
        response.put("fibonacci", normalResult);
        response.put("sorted", Arrays.asList(sortedNumbers));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
