package hometasktwo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class pageObjectTest {

    private WebDriver driver;
    private final Logger LOGGER = LogManager.getLogger(pageObjectTest.class);
    private final String HOME_PAGE = "http://rus.delfi.lv/";
    private final By ARTICLE_TITLES = By.xpath(".//a[@class = 'top2012-title']");
    private final By COMMENT_COUNT_ARTICLE = By.className("comment-count");
    // private final By ALL_COMMENTS = By.xpath("//*[contains(@class, 'comment-thread-switcher-selected-reg ')]/a/span");


    @Test
    public void checkArticleAndComments() {

        LOGGER.info("Starting Delfi page test.");
        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        LOGGER.info("Open home page.");

        driver.get(HOME_PAGE);

        LOGGER.info("Select article.");
        selectArticleTile(ARTICLE_TITLES);

        LOGGER.info("Get number of all comments on article page.");
        getCommentCount(COMMENT_COUNT_ARTICLE);

    }

    public void selectArticleTile(By locator) {
        List<WebElement> oneArticle = driver.findElements(locator);
        for (int i = 0; i < oneArticle.size(); i++) {
            oneArticle.get(i).click();
            break;
        }


    }

    public void getCommentCount(By locator) {
        List<WebElement> totalComments = driver.findElements(locator);
        //int totalCommentsSize = totalComments.size();
        System.out.println(totalComments.size()); //("Total number of comments : " + totalCommentsSize);


      /* List<WebElement> totalCount = driver.findElements(locator);
        for (int i = 0; i < totalCount.size(); i++) {
            totalCount.get(i).getSize();
            break;
            }*/
    }
}
