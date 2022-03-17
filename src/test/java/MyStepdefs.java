import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    }

    @Given("I write random email {string}")
    public void iHaveWrittenMyEmail(String email) {

        if (email.equals("")) {


        }else

            generateRandomEmail(driver, By.id("email"));

    }
    @Given("I write random name {string}")
    public void iHaveWrittenMyName(String name) {


        if (name.equals("randomName"))  {

            generateRandomUsrName(driver, By.id("new_username"), name + (new Random().nextInt(100000) + 1));
        }
        
        if (name.equals("randomUsed")) {

            generateRandomUsrName(driver, By.id("new_username"), "fredrik123");
        }

        if (name.equals("randomManyChars"))  {

            generateRandomUsrName(driver, By.id("new_username"), name+"testtesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttesttetesttestte");
        }
        if (name.equals("userNameMissingEmail"))  {

            generateRandomUsrName(driver, By.id("new_username"), name + (new Random().nextInt(100000) + 1));
        }

    }
    @Given("I write random password {string}")
    public void iHaveWrittenRandomPassword(String password) {

        generateRandomPassword(driver,By.id("new_password"));

    }

    @When("I click on submit")
    public void iClickOnSubmit() {

        clicker(driver, By.id("create-account"));
    }

    @Then("I Quit Test")
    public void quitTest() {


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();

    }

    private static void generateRandomUsrName(WebDriver driver, By by, String name) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        element.sendKeys(name);

    }

    private static void generateRandomEmail(WebDriver driver, By by) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elements = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        elements.sendKeys("randomEmail" + randomInt + "@gmail.com");

    }

    private static void generateRandomPassword(WebDriver driver, By by) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        element.sendKeys("Hunter$$" + randomInt);

    }

    private static void clicker(WebDriver driver, By by) {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }

}