package TestWork.tests;


import TestWork.tests.Base.BaseTest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FilmixSearchTest extends BaseTest {

    @Test
    public void testSearch()
    {
        testPage.searchBoxClick();
        testPage.searchBoxTypeText("Дэдпул");
        testPage.submitSearch();

        filmix_search_page.waitForResultsAppear();

        filmix_search_page.verifySearchResultQty();
    }
}
