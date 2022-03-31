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
    public void iHaveStartedBrowser(String browser) {
        DriveCreator choice = new DriveCreator();
        driver = choice.createBrowser(browser);
        driver.get("https://login.mailchimp.com/signup/");

        String actual = driver.getTitle();
        assertEquals("Signup | Mailchimp",actual);

    }

    @Given("I write random email {string}")
    public void iHaveWrittenMyEmail(String email) {

        if (email.equals("")) {

            String actual = email;
            assertEquals("",actual);

        }else
            typer(driver, By.id("email"), email + (new Random().nextInt(1000000))+ "@email.com");
    }

    @Given("I write a name {string}")
    public void iHaveWrittenMyName(String name) {

        if (name.equals("randomName"))  {

            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100000);
            typer(driver, By.id("new_username"), name + randomInt);

            String actual = name+randomInt;
            assertEquals(name+randomInt,actual);
        }
        
        if (name.equals("randomUsed")) {

            typer(driver, By.id("new_username"), "fredrik123");

        }

        if (name.equals("ManyChars"))  {

            typer(driver, By.id("new_username"), name+"testtesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttest");
        }

        if (name.equals("MissingEmail"))  {

            typer(driver, By.id("new_username"), name + (new Random().nextInt(100000) + 1));
        }
    }

    @Given("I write a password {string}")
    public void iHaveWrittenRandomPassword(String password) {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        typer(driver,By.id("new_password"),password+randomInt);
    }

    @When("I click on submit")
    public void iClickOnSubmit() {

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