import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyStepdefs {


    private String myName, myEmail, myPermanent, myCurrent, myBrowser;
    private WebDriver driver;

    @Given("I have started {string} browser")
    public void iHaveStartedBrowser(String browser) {


        DriveCreator choice = new DriveCreator();
        myBrowser = browser;
        driver = choice.createBrowser(browser);
        driver.get("https://demoqa.com/text-box");

    }

    @Given("I have written my name {string}")
    public void iHaveWrittenMyName(String name) {

        myName = name;
        typer(driver,By.id("userName"), name);

    }

    @Given("I have written my email {string}")
    public void iHaveWrittenMyEmail(String email) {

        myEmail = email;
        typer(driver, By.id("userEmail"),email);

    }

    @Given("I have written my current address {string}")
    public void iHaveWrittenMyCurrentAddress(String current) {


        myCurrent = current;
        typer(driver, By.id("currentAddress"),current);


    }

    @Given("I have written my permanent address {string}")
    public void iHaveWrittenMyPermanentAddress(String permanent) {

        myPermanent = permanent;
        typer(driver, By.id("permanentAddress"),permanent);

    }

    @When("I click on submit")
    public void iClickOnSubmit() {



    }

    @Then("my contact information is displayed")
    public void myContactInformationIsDisplayed() {


    }

    private static void typer(WebDriver driver, By by, String text) {

        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.presenceOfElementLocated(by));
        element.sendKeys(text);
    }

}