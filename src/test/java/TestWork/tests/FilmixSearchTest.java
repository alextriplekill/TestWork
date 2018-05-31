package TestWork.tests;


import TestWork.pages.Base_Page;
import TestWork.pages.Filmix_Film_Page;
import TestWork.pages.Filmix_Login_Form;
import TestWork.pages.Filmix_Search_Page;
import org.apache.commons.logging.Log;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class FilmixSearchTest extends BaseTest{


    @Test
    public void testSearch()
    {

        int searchResultsCount;

        testPage.searchBoxClick();
        testPage.searchBoxTypeText("Дэдпул");
        testPage.submitSearch();
        Filmix_Search_Page searchResultsPage = new Filmix_Search_Page(driver);

        searchResultsCount = searchResultsPage.countResults();

        Assert.assertTrue("Search results count", searchResultsCount == 2);
    }


}
