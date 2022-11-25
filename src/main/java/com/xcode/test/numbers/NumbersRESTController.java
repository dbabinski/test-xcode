package com.xcode.test.numbers;

import com.xcode.test.errorHandler.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/numbers")
public class NumbersRESTController {

    @Autowired
    public NumbersServices numbersServices;

    @PostMapping("/sort-command")
    public ArrayList<Integer> sortNumbers(@RequestBody Numbers numbers) {
        if (numbers.getNumbers() == null || numbers.getNumbers().isEmpty()) {
            throw new ErrorException("ERROR: Given data is empty.");
        }
        if (numbers.getOrder() == null || numbers.getOrder().equalsIgnoreCase("")) {
            numbers.setOrder("ASC");
        } else if (!numbers.getOrder().equals("ASC") || !numbers.getOrder().equals("DESC")) {
            return numbersServices.sortNumbers(numbers.getNumbers(), numbers.getOrder());
        } else {
            throw new ErrorException("Order method is not recongnized. Choose ASC or DESC.");
        }
        return numbersServices.sortNumbers(numbers.getNumbers(), numbers.getOrder());
    }
}
