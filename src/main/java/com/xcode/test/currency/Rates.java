package com.xcode.test.currency;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {

    @JsonProperty("currency")
    public String currency;
    @JsonProperty("code")
    public String code;

    @JsonProperty("mid")
    public String mid;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
