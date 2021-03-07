import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AllureTest extends BaseTest {

    @Epic("TEST ON https://mvnrepository.com SEARCHER.")
    @Feature("Test for finding.")
    @Severity(SeverityLevel.NORMAL)
    @Description("In this text we trying to find the Allure dependencie with Correct.")
    @Story("The way to aim page with correct last title")
    @Test
    public void testOfAllureCorrect() {
        searchField("Allure");
        pressSearchButton();
        findNeededHeader("Allure JUnit 5 Integration");
        choseVersion();
        checkTitleCorrect("Maven Repository: io.qameta.allure » allure-junit5 » 2.13.6");
    }

    @Epic("TEST ON https://mvnrepository.com SEARCHER.")
    @Feature("Test for finding.")
    @Severity(SeverityLevel.MINOR)
    @Description("In this text we trying to find the Allure dependencie with Incorrect.")
    @Story("The way to aim page with wrong/incorrect last title")
    @Test
    public void testOfAllureIncorrect() {
        searchField("Allure");
        pressSearchButton();
        findNeededHeader("Allure JUnit 5 Integration");
        choseVersion();
        checkTitleUncorrect("allure-junit4");
    }

    @Epic("TEST ON https://mvnrepository.com SEARCHER.")
    @Feature("Test for finding.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Wrong test")
    @Story("Try to crush the test")
    @Test
    public void testOfAllure() {
        searchField("Poro-koro");
        pressSearchButton();
        findNeededHeader("-");
        choseVersion();
        checkTitleCorrect("Maven Repository: io.qameta.allure » allure-junit5 » 2.13.6");
    }

    @Step("Input in search field")
    public void searchField(String searchTarget) {
        driver.findElement(By.id("query")).sendKeys(searchTarget);
    }

    @Step("Press Search button")
    public void pressSearchButton() {
        driver.findElement(By.className("button")).click();
    }

    @Step("Chose the header")
    public void findNeededHeader(String target) {
        driver.findElement(By.linkText(target)).click();
    }

    @Step("Chose needed version")
    public void choseVersion() {
        driver.findElement(By.cssSelector("a[href='allure-junit5/2.13.6']")).click();
    }

    @Step("Check the title on correct value")
    public void checkTitleCorrect(String title) {
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(title));
    }

    @Step("Check the title on wrong value")
    public void checkTitleUncorrect(String title) {
        Assert.assertFalse(driver.getTitle().equalsIgnoreCase(title));
    }
}
