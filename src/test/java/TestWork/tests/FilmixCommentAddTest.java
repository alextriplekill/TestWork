package TestWork.tests;

import TestWork.tests.Base.BaseTest;
import org.junit.Test;

public class FilmixCommentAddTest extends BaseTest {

    @Test
    public void testCommentaries()
    {
        testPage.authButtonClick();
        filmix_login_form.loginBoxClick();
        filmix_login_form.setLogin("pyrogun");
        filmix_login_form.passwordBoxClick();
        filmix_login_form.setPassword("745296183");
        filmix_login_form.submitAuth();
        filmix_login_form.waitUntilWidgetStayInvisibility();
        testPage.searchBoxClick();
        testPage.searchBoxTypeText("Дэдпул");
        testPage.submitSearch();
        filmix_search_page.clickMovieName();
        //filmPage.scrollToCommentSection();
        filmix_film_page.commentBtnClick();
        filmix_film_page.waitUntilCommentBeVisible();
        filmix_film_page.commentBoxClick();
        filmix_film_page.setCommentBox("Testing comments section with Selenium WebDriver for Java");
        filmix_film_page.submitComment();
        filmix_film_page.refreshPage();
        filmix_film_page.verifyThatCommentBeAdd();
    }

}
