package pages;

import helpers.LogHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private final static Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
        logger.info(LogHelper.getTestName() + "Page initialized");
    }

    @FindBy (name = "q")
    private WebElement searchFld;

    @FindBy (css = "input[class=lsb]")
    private WebElement searchBtn;


    public void enterSearchText(String text) {
        enterText(searchFld, text);
        logger.info(LogHelper.getTestName() + "Entered into search field: \"" + text + "\"");
    }

    public void clickSearchBtn() {
        clickBtn(searchBtn);
        logger.info(LogHelper.getTestName() + "Clicked Search button");
    }

}
