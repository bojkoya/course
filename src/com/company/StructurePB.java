package com.company;

import javax.naming.directory.Attribute;
import java.util.List;

/**
 * Created by yboiko on 23.08.18.
 */
public class StructurePB {
    private String date;
    private String bank;
    private String baseCurrency;
    private String baseCurrencyLit;
    private List<Currency> exchangeRate;

    public String getDate() {
        return date;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public List<Currency> getExchangeRate() {
        return exchangeRate;
    }

}
