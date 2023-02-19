package com.selenium.app.utility;

import com.github.javafaker.Faker;

public class Data {
    static Faker faker = new Faker();

    public static final String RandomTech = faker.app().name();

    public static final String TestStart = "******************* Starting Test *******************";
    public static final String TestComplete = "******************* Test Execution Completed *******************";
    public static final String HOME_PAGE = "https://ecommerce-playground.lambdatest.io/";
    public static final String PAGE_TITLE = "Your Store";
}
