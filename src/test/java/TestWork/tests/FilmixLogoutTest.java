package TestWork.tests;

import TestWork.tests.Base.BaseTest;
import org.junit.Test;

public class FilmixLogoutTest extends BaseTest {
    @Test
    public void testDeauthentication()
    {
        testPage.authButtonClick();

        filmix_login_form.loginBoxClick();
        filmix_login_form.setLogin("pyrogun");
        filmix_login_form.passwordBoxClick();
        filmix_login_form.setPassword("745296183");
        filmix_login_form.submitAuth();
        testPage.profileDetailsClick();
        testPage.logoutClick();

        testPage.verifyDeauthentication();
    }


}
