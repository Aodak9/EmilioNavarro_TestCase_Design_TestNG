package org.espn.tests;

import org.espn.pages.UserOptionsOnIframe;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class UserLogout extends BaseTest{
    @Test(priority = 3)
    public void logOut(){
        UserOptionsOnIframe userOptionsOnIframe = navigationBar.clickOnUserOptions();
        userOptionsOnIframe.executeClickOnLogOutButton();
        userOptionsOnIframe.reloadPage();
        userOptionsOnIframe = navigationBar.clickOnUserOptions();
        checkThat("user is Offline", userOptionsOnIframe.userOffline(), is(true));
        navigationBar.clickOnUserButtonIframe();
        userOptionsOnIframe.reloadPage();
    }
}
