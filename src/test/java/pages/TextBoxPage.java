package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TextBoxPage {
    private WebDriver driver;
    private String baseUrl;

    public TextBoxPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    private final By userName = By.id("userName");
    private final By userEmail = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submitButton = By.id("submit");

    public TextBoxPage openPage(String path) {
        this.driver.get(baseUrl + path);
        return this;
    }

    public TextBoxPage setUserName(String userName) {
        driver.findElement(this.userName).sendKeys(userName);
        return this;
    }

    public TextBoxPage setUserEmail(String userEmail) {
        driver.findElement(this.userEmail).sendKeys(userEmail);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        driver.findElement(this.currentAddress).sendKeys(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        driver.findElement(this.permanentAddress).sendKeys(permanentAddress);
        return this;
    }

    public TextBoxPage clickSubmit() {
        driver.findElement(this.submitButton).click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        String output = driver.findElement(By.xpath(".//p[contains(text(),'" + key + "')]")).getText();
        assert output.contains(value);
        return this;
    }
}
