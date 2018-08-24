package com.company;

import com.google.gson.Gson;

import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main {

    public static final String FORMAT = "dd.MM.yyyy";

    public static void main(String[] args) throws IOException, ParseException, NamingException {
        String urlPathOne = "https://api.privatbank.ua/p24api/exchange_rates?json&date=";
        String urlPathTwo = myDate();
        String result = urlPathOne + urlPathTwo;
        HttpUtil.sendRequest(result, null, null);
        System.out.println("Result: " + result);

        Gson gson = new Gson();
        StructurePB currency = gson.fromJson(result, StructurePB.class);
        if (currency.getExchangeRate().size() == 0) {
            System.out.println("Upon this date information about the course of currencies is absent, check the correctness of the input.");
        } else {
            for (int i = 0; i < currency.getExchangeRate().size(); i++) {
                if (currency.getExchangeRate().get(i).getCurrency().equals("USD")) {
                    System.out.println("The dollar exchange rate for this date is: " + String.valueOf(currency.getExchangeRate().get(i).getSaleRateNB()) + " grn");
                }
            }}

    }

    private static String myDate() throws ParseException, IOException {

        System.out.println("Enter the date in this format dd.MM.YYYY:");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sd = null;

        try {
            sd = reader.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
            LocalDate parse = LocalDate.parse(sd, formatter);
            return parse.format(formatter);
        } catch (Exception e) {
            System.out.println("Invalid date format " + e);
            System.out.println();
            return myDate();

        }
    }



    }
