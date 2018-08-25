import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchResultPage;
import tests.BaseTest;
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
        assertTrue(driver.get().getTitle().contains("automation"), "Expected title contains: \"automation\", Actual title: " + driver.get().getTitle());
    }

    @Test
    public void resultDomainsTest() {
        HomePage homePage = new HomePage(driver.get());
        homePage.enterSearchText("automation");
        homePage.clickSearchBtn();
        SearchResultPage resultPage= new SearchResultPage(driver.get());
        List<String> links = resultPage.getResultLinks();
        SoftAssert softAssert = new SoftAssert();
        for (int i = 1; i <= 5; i++) {
            softAssert.assertTrue(links.get(i).contains("testautomationday.com"), "Expected: link contains \"testautomationday.com\", Actual: " + links.get(i));
        }
        softAssert.assertAll();
    }
}
