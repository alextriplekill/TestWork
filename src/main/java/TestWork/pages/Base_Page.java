package TestWork.pages;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class Base_Page{

    public WebDriver driver;

    @FindBy(xpath = "//input[@id= 'search']")
    private WebElement searchBox;

    @FindBy(id = "auth")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[@class = 'login']/span")
    private WebElement userProfile;

    @FindBy(xpath = "//div[@class = 'login opened']/div[@class = 'login-items']/a[@class = 'login-item logoute']")
    private WebElement logoutBtn;

    public Base_Page(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    public void openUrl(String url)
    {
        driver.get(url);
    }

    public void searchBoxClick() {
        searchBox.click();
    }
    public void searchBoxTypeText(String text)
    {
        searchBox.sendKeys(text);
    }
    public void submitSearch()
    {
        searchBox.submit();
    }
    public void profileDetailsClick(){
        userProfile.click();
    }

    public void logoutClick(){
        logoutBtn.click();
    }

    public void authButtonClick() {
        loginBtn.click();
    }

    public boolean isAuthButtonDisplayed(){
        return loginBtn.isDisplayed();
    }

    public void verifyDeauthentication(){
        Assert.assertTrue("Checking if we logged out", this.isAuthButtonDisplayed());
    }
}
