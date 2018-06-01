package TestWork.tests;

import TestWork.tests.Base.BaseTest;
import org.junit.Test;

public class FilmixCommentDeleteTest extends BaseTest {

    @Test
    public void testCommentDeletion()
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
        filmix_film_page.deleteCommentBtnClick();
        filmix_film_page.deletionAcceptBtnClick();

        filmix_film_page.verifyCommentDeletion();
    }
}
