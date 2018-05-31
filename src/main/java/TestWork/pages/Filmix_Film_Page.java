package TestWork.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Filmix_Film_Page extends Base_Page{


    @FindBy(xpath = "//div[@class = 'line-block']//div[@id = 'comments']/span[text()='Добавить отзыв']")
    private WebElement addCommentBtn;

    @FindBy(xpath = "//body[@id = 'tinymce']")
    private WebElement commentBox;

    @FindBy(css = "div.comment-box.my:nth-child(1)")
    private List<WebElement> commentPanel;

    @FindBy(xpath = "//header/div[@class = 'comment-delete']")
    private WebElement deleteCommentBtn;

    @FindBy(xpath = "/body")
    private WebElement bodyObject;

    @FindBy(xpath = "//div[@class = 'fieldsubmit']/button")
    private WebElement commentSubmitBtn;

    @FindBy(xpath = "//label[contains(text(), 'комментарий')]")
    private WebElement commentLabel;

    @FindBy(xpath = "//div[@class = 'comment-text']")
    private WebElement commentText;

    @FindBy(css = "button.mini:nth-child(2)")
    private WebElement deletionAcceptBtn;

    public Filmix_Film_Page(WebDriver driver)
    {
        super(driver);
    }

    public void commentBtnClick(){
        addCommentBtn.click();
    }

    public void commentBoxClick(){
        commentLabel.click();
        driver.switchTo().frame("comments_ifr");
    }

    public void setCommentBox(String text)
    {
        commentBox.sendKeys(text);
    }

    public void scrollToCommentSection(){
        bodyObject.sendKeys(Keys.PAGE_DOWN);
    }

    public void submitComment(){
        driver.switchTo().parentFrame();
        commentSubmitBtn.click();
    }

    public String getTopComment()
    {
        return commentPanel.get(0).getText();
    }

    public void refreshPage()
    {
        driver.navigate().refresh();
    }

    public void deleteCommentBtnClick(){
        deleteCommentBtn.click();

    }

    public boolean checkCommentDeletion()
    {
        boolean result = false;
        try
        {
           commentText.getText();
        }
        catch (NoSuchElementException ex)
        {
            result = true;
        }
        return result;
    }

    public void deletionAcceptBtnClick()
    {
        deletionAcceptBtn.click();
    }

    public void waitUntilCommentBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'комментарий')]")));
    }

    public void verifyThatCommentBeAdd(){
        Assert.assertTrue("Checking if comment is added to page", this.getTopComment().contains("Testing comments section with Selenium WebDriver for Java"));
    }

    public void verifyCommentDeletion(){
        Assert.assertTrue("Testing comment deletion", this.checkCommentDeletion());
    }

}
