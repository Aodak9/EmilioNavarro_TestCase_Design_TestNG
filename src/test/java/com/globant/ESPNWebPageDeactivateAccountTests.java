package com.globant;

import org.testng.annotations.Test;

public class ESPNWebPageDeactivateAccountTests extends BaseClass{
    @Test(dataProvider = "loginData", priority = 4)
    public void logOut(String emailAddress, String password) {
        log.info("Take cursor over the person icon in the navigation bar");
        log.info("Click on 'Log In' option");
        log.info("Type " + emailAddress + " in 'Username or Email Address' field");
        log.info("Type " + password + " in 'Password (case sensitive)' field");
        log.info("Click on 'Log In' btn");
        log.info("Take cursor over the person icon in the navigation bar");
        log.info("Click on 'ESPN Profile' option");
        log.info("Click on 'Delete Account' option");
        log.info("Click on 'Yes, delete this account' btn");
        log.info("Click on 'OK' btn");
        log.info("Put mouse cursor over the person icon in the navigation bar");
        log.info("Verify if successfully logged out");
        log.info("Type " + emailAddress + " in 'Username or Email Address' field");
        log.info("Type " + password + " in 'Password (case sensitive)' field");
        log.info("Verify if the message 'It looks like the account for " + emailAddress + " has been deactivated. Please contact ESPN Customer Care if you believe this was in error or try another account.' is shown");
        System.out.println();
    }
}
