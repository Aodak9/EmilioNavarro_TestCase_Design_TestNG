package com.globant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class BaseClass {
    protected static Logger log = LoggerFactory.getLogger(BaseClass.class);

    @DataProvider (name = "loginData")
        public Object[][] getLoginData () {
            return new Object[][] {{"hormiguita1@email.com", "antanimal1"}};
    }

    @DataProvider (name = "invalidData")
        public Object [][] getInvalidData(){
            return new Object[][] {{"hormiguita2@gmail.com", "antanimal2"}};
        }

    @BeforeSuite
    public void CreateAccount(){
        log.info("Open the Navigator");
        log.info("Go to https://www.espnqa.com/?_adbock=true&src=com");
        log.info("Take cursor in person icon on nav bar");
        log.info("If account is still not created select 'Log In' ");
        log.info("If needed select 'Sign Up' option");
        log.info("Create an account");
        log.info("Exit Navigator");
        System.out.println();
    }

    @BeforeTest
    public void openNavigator(){
        log.info("Open Navigator");
        System.out.println();
    }

    @BeforeMethod
    public void cleanCookies(){
        log.info("Go to https://www.espnqa.com/?_adbock=true&src=com");
        log.info("Click on 'View site information' btn");
        log.info("Click on 'Cookies' option");
        log.info("Remove all cookies");
        System.out.println();
    }

    @AfterTest
    public void closeNavigator(){
        log.info("Close Navigator");
        System.out.println();
    }
}


