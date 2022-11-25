package com.xcode.test.currency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xcode.test.errorHandler.ErrorException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyServices {

    public Table table;
    private String url = "https://api.nbp.pl/api/exchangerates/tables/A/?format=json";

    public ResponseValue getData(String code)  {
        ResponseValue responseValue = new ResponseValue();
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(url, String.class);
        String result = json.substring(1, json.length() - 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.table = mapper.readValue(result, Table.class);
        } catch (JsonProcessingException e) {
            throw new ErrorException("Error: Cannot map result to object." + e);
        }
        List<Rates> rates = table.getRates();
        rates = rates.stream().filter(rate -> rate.getCode().equals(code)).collect(Collectors.toList());

        responseValue.setValue(rates.get(0).getMid());
        return responseValue;
    }
}
