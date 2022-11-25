package com.xcode.test.currency;

import com.xcode.test.errorHandler.ErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
public class CurrencyValueRESTController {

    @Autowired
    public CurrencyServices currencyServices;

    @PostMapping("/get-current-currency-value-command")
    public ResponseValue getCurrentCurrencyValue(@RequestBody Rates currency) {
        if (currency.code == null || currency.code.equalsIgnoreCase("")) {
            throw new ErrorException("Error: Invalid currency code.");
        } else {
            return currencyServices.getData(currency.code);
        }
    }
}
