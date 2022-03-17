/*

    private static void typer(WebDriver driver, By by, String text) {

        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.presenceOfElementLocated(by));
        element.sendKeys(text);
    }
    private static void clicker(WebDriver driver, By by) {

        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
    private static void selector(WebDriver driver, String choice) {

        Select dropdown = new Select(driver.findElement(By.id("oldSelectMenu")));
        dropdown.selectByValue(choice);
    }
    private static void getTextFromTag (WebDriver driver, String tagName) {

        List<WebElement> elements = driver.findElements(By.tagName(tagName));
        for (WebElement output : elements) {
            System.out.println(output.getText());
        }
   
    private static void getTextFromId (WebDriver driver, String IdName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement getTextFromElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(IdName)));
        System.out.println(getTextFromElement.getText());

}

public class DriveCreator {
    public WebDriver createBrowser (String browser) {

        WebDriver driver;

        if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "/Users/inaco/Documents/Selenium/msedgedriver");
            driver = new EdgeDriver();

        } else {
            System.setProperty("webdriver.chrome.driver", "/Users/inaco/Documents/Selenium/chromedriver");
            driver = new ChromeDriver();

        }
        return driver;
    }

    }

    private static void generateRandomUsrName(WebDriver driver, By by) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        element.sendKeys("randomUserName"+ (new Random().nextInt(100000) + 1));

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


*/

/*

                //Skriver ut text
                typer(driver, By.id("firstName"), "Fredrik");
                typer(driver, By.id("lastName"), "Agren");
                typer(driver, By.id("userEmail"), "Fredrik@mail.com");
                typer(driver,By.id("userNumber"), "07255665543");

                //Klickar på knappar
                clicker(driver, By.xpath(""));
                clicker(driver, By.id(""));
                clicker(driver, By.tagName(""));

                //"väljer" ett alternativ
                selector(driver,"red");

                //hämtar text kopplat till element - "tag"
                getTextFromTag(driver,"div");

                //hämtar text kopplat till element - "id"
                getTextFromId(driver,"app");

                 //genrera random uppgifter
                 generateRandomEmail(driver, By.id("email"));
                 generateRandomUsrName(driver, By.id("new_username"));
                 generateRandomPassword(driver,By.id("new_password"));

 */