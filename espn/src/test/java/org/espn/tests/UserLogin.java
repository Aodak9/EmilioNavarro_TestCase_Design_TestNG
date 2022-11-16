package org.espn.tests;

import org.espn.pages.LoginOnIframe;
import org.espn.pages.UserOptionsOnIframe;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class UserLogin extends BaseTest{
    @Test(priority = 1)
    public void login(){
        UserOptionsOnIframe userOptionsOnIframe = navigationBar.clickOnUserOptions();
        LoginOnIframe loginOnIframe = userOptionsOnIframe.executeClickOnLoginButton();
        checkThat("Modal is present", loginOnIframe.loginFormElementsDisplayed(), is(true));
        loginOnIframe.typeOnEmailInput(email);
        loginOnIframe.typeOnPasswordInput(PASSWORD);
        loginOnIframe.clickOnLoginButtonIframe();
        userOptionsOnIframe = navigationBar.clickOnUserOptions();
        checkThat("login succeded", userOptionsOnIframe.getUsernameLogged(), is(USER));
        navigationBar.clickOnUserButtonIframe();
    }




}
