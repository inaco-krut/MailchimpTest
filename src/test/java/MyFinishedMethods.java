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



*/

/*



                //Skriver ut text
                typer(driver, By.id("firstName"), "Fredrik");
                typer(driver, By.id("lastName"), "Agren");
                typer(driver, By.id("userEmail"), "Fredrik@mail.com");
                typer(driver,By.id("userNumber"), "07255665543");

                //Klickar på knappar
                clicker(driver, By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/label"));
                clicker(driver, By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]/div[3]/label"));
                clicker(driver, By.id("submit"));

                //"väljer" ett alternativ
                selector(driver,"red");

                //hämtar text kopplat till element - "tag"
                getTextFromTag(driver,"div");

                //hämtar text kopplat till element - "id"
                getTextFromId(driver,"app");



 */