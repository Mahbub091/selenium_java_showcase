package com.selenium.app;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class test {
    public static void main(String[] args) {
        String s = RandomStringUtils.randomAlphanumeric(8).toUpperCase(Locale.ROOT);
        System.out.println(s);

        Faker faker = new Faker();

    }
}
