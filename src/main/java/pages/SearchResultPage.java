package pages;

import helpers.LogHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {

    private final static Logger logger = Logger.getLogger(SearchResultPage.class);

    @FindBy (css = "h3 > a:last-child")
    private List<WebElement> resultLinks;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        logger.info(LogHelper.getTestName() + "Page initialized");
    }

    public void clickLinkByNumber(int number) {
        logger.info(LogHelper.getTestName() + "Link(" + number + ") address: " + resultLinks.get(number - 1).getAttribute("href"));
        resultLinks.get(number - 1).click();
        logger.info(LogHelper.getTestName() + "Link(" + number + ") clicked");
    }

    public List<String> getResultLinks() {
        List<String> linksText = new ArrayList<String>();
        for (WebElement linkEl: resultLinks) {
            linksText.add(linkEl.getAttribute("href"));
            logger.info(LogHelper.getTestName() + "Search result link(" + (resultLinks.indexOf(linkEl) + 1) + ") address: " + linkEl.getAttribute("href"));
        }
        return linksText;
    }
}
