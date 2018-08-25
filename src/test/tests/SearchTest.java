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
        boolean result = false;
        for (int i = 2; i <=5; i++) {
            SearchResultPage resultPage = new SearchResultPage(driver.get());
            List<String> links = resultPage.getResultLinks();
            for (String link: links) {
                if (link.contains("testautomationday.com")) {
                    result = true;
                    break;
                }
            }
            resultPage.openPageByNumber(i);
        }
        assertTrue(result, "\"testautomationday.com\" domain present in links of first 5 search result pages");
    }
}
