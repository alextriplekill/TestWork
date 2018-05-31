package TestWork.tests;

import TestWork.pages.Base_Page;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest
{
    static WebDriver driver;
    static Base_Page testPage;

    @BeforeClass
    public static void init()
    {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");




    }

    @Before
    public void openBasePage()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testPage = new Base_Page(driver);
        testPage.openUrl("http://filmix.co");

    }

    @After
    public void closeTestWindow()
    {
        driver.close();
    }

    @AfterClass
    public static void exitTestEnvironment()
    {
        driver.quit();
    }
}
