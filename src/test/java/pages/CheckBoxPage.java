package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckBoxPage {
    private WebDriver driver;
    private String baseUrl;

    public CheckBoxPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    private final By expandAll = By.className("rct-option-expand-all");
    private final By collapseAll = By.className("rct-option-collapse-all");
    private final By rctNodeParrent = By.className("rct-node-parent");

    public CheckBoxPage openPage(String path) {
        this.driver.get(baseUrl + path);
        return this;
    }

    public CheckBoxPage clickExpandAll() {
        driver.findElement(this.expandAll).click();
        return this;
    }

    public CheckBoxPage clickCollapseAll() {
        driver.findElement(this.collapseAll).click();
        return this;
    }

    public void isExpanded() {
        List<WebElement> elms = driver.findElements(this.rctNodeParrent);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        for (WebElement elm : elms) {
            assert wait.until(ExpectedConditions.attributeContains(elm, "class", "rct-node-expanded"));
        }
    }

    public void isCollapsed() {
        List<WebElement> elms = driver.findElements(this.rctNodeParrent);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        for (WebElement elm : elms) {
            assert wait.until(ExpectedConditions.attributeContains(elm, "class", "rct-node-collapsed"));
        }
    }
}
