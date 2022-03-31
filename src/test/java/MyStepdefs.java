import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
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
            case "randomName" -> {
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(100000);
                typer(driver, By.id("new_username"), name + randomInt);
                assertEquals("randomName", name);
            }
            case "randomUsed" -> {
                typer(driver, By.id("new_username"), "fredrik123");
                assertEquals("randomUsed", name);
            }
            case "manyChars" -> {
                typer(driver, By.id("new_username"), name + "testtesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttest");
                assertEquals("manyChars", name);
            }
            case "missingEmail" -> {
                typer(driver, By.id("new_username"), name + (new Random().nextInt(100000) + 1));
                assertEquals("missingEmail", name);
            }
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