package com.globant;

import org.testng.annotations.Test;

public class ESPNWebPageLogoutTests extends BaseClass {
    @Test(dataProvider = "loginData", priority = 3)
    public void logOut(String emailAddress, String password) {
        log.info("Take cursor over the person icon in the navigation bar");
        log.info("Click on 'Log In' option");
        log.info("Type " + emailAddress + " in 'Username or Email Address' field");
        log.info("Type " + password + " in 'Password (case sensitive)' field");
        log.info("Click on 'Log In' btn");
        log.info("Put mouse cursor over the person icon in the navigation bar");
        log.info("Click on 'Log Out' option");
        log.info("Put mouse cursor over the person icon in the navigation bar");
        log.info("Verify if successfully logged out");
        System.out.println();
    }
}
