package com.automationpractice.ecommerce.testCases;

import com.automationpractice.ecommerce.pages.SkillTestPage;
import org.testng.annotations.Test;

public class SkillTest extends BaseClass {

    @Test
    public void skillTest(){
        SkillTestPage testPage = new SkillTestPage(driver);

        testPage.visit("https://the-internet.herokuapp.com/");
    }








}
