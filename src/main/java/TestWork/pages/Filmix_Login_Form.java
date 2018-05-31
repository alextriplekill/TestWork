package TestWork.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Filmix_Login_Form extends Base_Page {
    public Filmix_Login_Form(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id = 'authblock']//article/form[@id = 'loginForm']//input[@id = 'login_name']")
    private WebElement login;

    @FindBy(xpath = "//div[@id = 'authblock']//article/form[@id = 'loginForm']//input[@id = 'login_password']")
    private WebElement password;

    @FindBy(className = "user-name ")
    private WebElement userProfileBtn;

    public void loginBoxClick() {
        login.click();
    }

    public void passwordBoxClick() {
        password.click();
    }

    public void setLogin(String text) {
        login.sendKeys(text);
    }

    public void setPassword(String text) {
        password.sendKeys(text);
    }

    public void submitAuth() {
        password.submit();
    }

    public String getUsername() {
        return userProfileBtn.getText();
    }

    public void waitUntilWidgetStayInvisibility() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class = 'ui-widget-overlay']")));
    }

    public void verifyAuthentication(){
        Assert.assertTrue("Checking if we logged in", this.getUsername().equals("pyrogun"));
    }

}
