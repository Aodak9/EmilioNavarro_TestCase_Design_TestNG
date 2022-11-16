package org.espn.tests;

import org.espn.pages.UserOptionsOnIframe;
import org.espn.pages.WatchPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class UserWatch extends BaseTest{
    @Test(priority = 2)
    public void watchPageNav(){
        WatchPage watchPage = navigationBar.ClickOnWatchPage();
        checkThat("more than one carousel is present", watchPage.watchPageElementsDisplayed(), is(true));
        watchPage.clickOnSecondCardOfCarousel();
        checkThat("choose supplier frame is present", watchPage.exitFromChooseSupplierButtonDisplayed(), is(true));
        watchPage.exitFromChooseSupplierButtonDisplayed();
        watchPage.navToBasePage();
        UserOptionsOnIframe userOptionsOnIframe = navigationBar.clickOnUserOptions();
        checkThat("user still online", userOptionsOnIframe.getUsernameLogged(), is(USER));
        navigationBar.clickOnUserButtonIframe();
    }
}
