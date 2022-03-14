import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

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
