import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

public class MyStepdefs {

    private WebDriver driver;

    @Given("I have started browser {string}")
    public void launchBrowser(String browser) {
        DriveCreator choice = new DriveCreator();
        driver = choice.createBrowser(browser);
        driver.get("https://login.mailchimp.com/signup/");

        String actual = driver.getTitle();
        assertEquals("Signup | Mailchimp",actual);

    }

    @Given("I write random email {string}")
    public void writeEmail(String email) {

        if (email.equals("")) {


        }else
            typer(driver, By.id("email"), email + (new Random().nextInt(1000000))+ "@email.com");
    }

    @Given("I write a name {string}")
    public void writeName(String name) {

        switch (name) {
            case "randomName":
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(100000);
                typer(driver, By.id("new_username"), name + randomInt);
                break;

            case "randomUsed":
                typer(driver, By.id("new_username"), "fredrik123");
                break;

            case "manyChars":
                typer(driver, By.id("new_username"), name + "testtesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttest");
                break;

            case "missingEmail":
                typer(driver, By.id("new_username"), name + (new Random().nextInt(100000) + 1));
                break;
        }
    }

    @Given("I write a password {string}")
    public void writePassword(String password) {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        typer(driver,By.id("new_password"),password+randomInt);
    }

    @When("I click on submit")
    public void clickOnSubmit() {

        clicker(driver, By.id("create-account"));
    }

    @And("I check asserts {string}")
    public void iCheckAssert(String text) {

        switch (text) {

            case "checkEmail":
                assertTrue(driver.getPageSource().contains("Check your email"));
                break;

            case "longText":
                assertTrue(driver.getPageSource().contains("Enter a value less than 100 characters long"));
                break;

            case "textUsed":
                assertTrue(driver.getPageSource().contains("Another user with this username already exists. Maybe it's your evil twin. Spooky."));
                break;

            case "textMissing":
                assertTrue(driver.getPageSource().contains("Please enter a value"));
                break;
        }
    }

    @Then("I Quit Test")
    public void quitTest() {

        driver.close();
    }

    private static void typer(WebDriver driver, By by, String s) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        element.sendKeys(s);

    }

    private static void clicker(WebDriver driver, By by) {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }
}