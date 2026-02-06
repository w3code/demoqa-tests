package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    private WebDriver driver;
    private String baseUrl;

    public FormPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    private final By firstNameEl = By.xpath("//input[@id='firstName']");
    private final By lastNameEl = By.xpath("//input[@id='lastName']");
    private final By userEmailEl = By.xpath("//input[@id='userEmail']");
    private final By userNumberEl = By.xpath("//input[@id='userNumber']");
    private final By dateOfBirthEl = By.xpath("//input[@id='dateOfBirthInput']");
    private final By subjectEl = By.xpath("//input[contains(@id,'subjectsInput')]");
    private final By uploadPictureEl = By.xpath("//input[@id='uploadPicture']");
    private final By currentAddressEl = By.xpath("//textarea[@id='currentAddress']");
    private final By selectStateEl = By.xpath("//div[contains(text(),'Select State')]");
    private final By selectCityEl = By.xpath("//div[contains(text(),'Select City')]");
    private final By submitButtonEl = By.xpath("//button[@id='submit']");
    private final By modalEl = By.xpath(".fade.modal.show");
    private final By closeButtonEl = By.xpath("//button[@id='closeLargeModal']");

    public FormPage openPage(String path) {
        this.driver.get(baseUrl + path);
        return this;
    }

    public FormPage setFirstName(String firstName) {
        driver.findElement(firstNameEl).sendKeys(firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        driver.findElement(lastNameEl).sendKeys(lastName);
        return this;
    }

    public FormPage setUserEmail(String userEmail) {
        driver.findElement(userEmailEl).sendKeys(userEmail);
        return this;
    }

    public FormPage setGender(String gender) {
        driver.findElement(By.xpath("//div[contains(@class,'custom-radio')]/label[contains(text(),'" + gender + "')]")).click();
        return this;
    }

    public FormPage setUserNumber(String userNumber) {
        driver.findElement(userNumberEl).sendKeys(userNumber);
        return this;
    }

    public FormPage setDateOfBirth(String userBirthDay, String userBirthMonth, String userBirthYear) {
        driver.findElement(dateOfBirthEl).click();
        driver.findElement(By.xpath("//select[contains(@class,'react-datepicker__month-select')]/option[contains(text(),'" + userBirthMonth + "')]")).click();
        driver.findElement(By.xpath("//select[contains(@class,'react-datepicker__year-select')]/option[@value='" + userBirthYear + "']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--0" + userBirthDay + "')]")).click();
        return this;
    }

    public FormPage setSubject(String subject) {
        driver.findElement(subjectEl).sendKeys(subject);
        driver.findElement(By.xpath("//div[contains(@id,'react-select-2-option')][contains(text(),'" + subject + "')]")).click();
        return this;
    }

    public FormPage setUserHobby(String userHobby) {
        driver.findElement(By.xpath("//div[contains(@class,'custom-checkbox')]/label[contains(text(),'" + userHobby + "')]")).click();
        return this;
    }

    public FormPage uploadPicture() {
        driver.findElement(uploadPictureEl).sendKeys("D:\\at.jpg");
        return this;
    }

    public FormPage setCurrentAddress(String currentAddress) {
        driver.findElement(currentAddressEl).sendKeys(currentAddress);
        return this;
    }

    public FormPage setState(String state) {
        driver.findElement(selectStateEl).click();
        driver.findElement(By.xpath("//div[contains(@id,'react-select-3-option')][contains(text(),'" + state + "')]")).click();
        return this;
    }

    public FormPage setCity(String city) {
        driver.findElement(selectCityEl).click();
        driver.findElement(By.xpath("//div[contains(@id,'react-select-4-option')][contains(text(),'" + city + "')]")).click();
        return this;
    }

    public FormPage submitClick() {
        driver.findElement(submitButtonEl).click();
        return this;
    }

    public FormPage checkResult(String key, String value) {
        assert driver.findElement(By.xpath("//td[preceding-sibling::td[contains(.,'" + key + "')]]")).getText().contains(value);
        return this;
    }

    public FormPage closeModal() {
        driver.findElement(closeButtonEl).click();
        return this;
    }
}
