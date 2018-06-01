package TestWork.tests.Base;

import TestWork.pages.Base_Page;
import TestWork.pages.Filmix_Film_Page;
import TestWork.pages.Filmix_Login_Form;
import TestWork.pages.Filmix_Search_Page;
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
    protected Base_Page testPage;
    protected Filmix_Login_Form filmix_login_form;
    protected Filmix_Search_Page filmix_search_page;
    protected Filmix_Film_Page filmix_film_page;

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
        filmix_login_form = new Filmix_Login_Form(driver);
        filmix_search_page = new Filmix_Search_Page(driver);
        filmix_film_page = new Filmix_Film_Page(driver);
        testPage.openUrl("http://filmixme.net");

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
