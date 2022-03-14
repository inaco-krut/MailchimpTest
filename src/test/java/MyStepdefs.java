import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;


public class MyStepdefs {

    private WebDriver driver;

    @Given("I have started browser {string}")
    public void iHaveStartedBrowser(String browser) {
        DriveCreator choice = new DriveCreator();
        driver = choice.createBrowser(browser);
        driver.get("https://login.mailchimp.com/signup/");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Signup | Mailchimp";

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Given("I write random email {string}")
    public void iHaveWrittenMyEmail(String email) {

        GenerateRandomEmail(driver, By.id("email"));

    }
    @Given("I write random name {string}")
    public void iHaveWrittenMyName(String name) {

        GenerateRandomUsrName(driver, By.id("new_username"));

    }
    @Given("I write random password {string}")
    public void iHaveWrittenRandomPassword(String password) {

        GenerateRandomPassword(driver,By.id("new_password"));

    }
    @When("I click on submit")
    public void iClickOnSubmit() {

        clicker(driver, By.id("create-account"));
    }

    @Then("I verify the email Address")
    public void iVeryTheEmailAddress() {

    driver.quit();

    }

    private static void GenerateRandomUsrName(WebDriver driver, By by) {

        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.presenceOfElementLocated(by));
        element.sendKeys("GeneratedUserName"+ (new Random().nextInt(10000) + 1));

    }
    private static void GenerateRandomEmail (WebDriver driver, By by) {

        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elements = foobar.until(ExpectedConditions.presenceOfElementLocated(by));
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        elements.sendKeys("RandomEmail" + randomInt + "@gmail.com");


    }

    private static void GenerateRandomPassword(WebDriver driver, By by) {

        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.presenceOfElementLocated(by));
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10000);
        element.sendKeys("Hunter$$" + randomInt);

    }

    private static void clicker(WebDriver driver, By by) {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }
}