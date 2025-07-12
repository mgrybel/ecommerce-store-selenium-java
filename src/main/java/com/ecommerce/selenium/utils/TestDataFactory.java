package com.ecommerce.selenium.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataFactory {
    public final static String positiveEmail;
    public final static String negativeEmail;
    public final static String takenEmail;
    public final static String password;

    static {
        Faker faker = new Faker(new Locale("pl-PL"));

        positiveEmail = faker.internet().emailAddress();
        negativeEmail = faker.name().username();
        takenEmail = faker.internet().emailAddress();
        password = faker.regexify("[a-z]{1}[A-Z]{1}[0-9]{1}[@#$%!]{1}[A-Za-z0-9@#$%]{4,8}");
    }
}
