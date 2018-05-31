package TestWork.tests;

import TestWork.pages.Filmix_Film_Page;
import TestWork.pages.Filmix_Login_Form;
import TestWork.pages.Filmix_Search_Page;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilmixLoginTest extends BaseTest {
    @Test
    public void testAuthentication()
    {
        testPage.authButtonClick();
        Filmix_Login_Form LoginForm = new Filmix_Login_Form(driver);
        LoginForm.loginBoxClick();
        LoginForm.setLogin("pyrogun");
        LoginForm.passwordBoxClick();
        LoginForm.setPassword("745296183");
        LoginForm.submitAuth();

        Assert.assertTrue("Checking if we logged in", LoginForm.getUsername().equals("pyrogun"));
    }


}
