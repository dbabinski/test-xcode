package com.xcode.test.numbers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NumbersServices implements NumbersInterface{

    @Override
    public ArrayList<Integer> sortNumbers(ArrayList<Integer> numbers, String orderMethod) {
        if (!numbers.isEmpty()) {
            if (orderMethod.equals("ASC")) {
                Collections.sort(numbers);
            } else if (orderMethod.equals("DESC")) {
                Collections.sort(numbers, Collections.reverseOrder());
            } else {
                numbers.clear();
            }
        }
        return numbers;
    }
}
