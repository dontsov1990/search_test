import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

import java.util.List;
import static org.testng.Assert.*;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest() {
        HomePage homePage = new HomePage(driver.get());
        homePage.enterSearchText("automation");
        homePage.clickSearchBtn();
        SearchResultPage resultPage= new SearchResultPage(driver.get());
        resultPage.clickLinkByNumber(1);
        assertTrue(driver.get().getTitle().contains("automation"), "First search result page title contains: \"automation\"");
    }

    @Test
    public void resultDomainsTest() {
        HomePage homePage = new HomePage(driver.get());
        homePage.enterSearchText("automation");
        homePage.clickSearchBtn();
        SearchResultPage resultPage= new SearchResultPage(driver.get());
        List<String> links = resultPage.getResultLinks();
        boolean result = false;
        for (int i = 0; i < 5; i++) {
            if(links.get(i).contains("testautomationday.com")) {
                result = true;
                break;
            }
        }
        assertTrue(result, "\"testautomationday.com\" domain present in first 5 search results");
    }
}
