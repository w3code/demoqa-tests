import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class ElementsTests extends TestBase {
    @Test
    void textBoxTest() {
        TextBoxPage textBoxPage = new TextBoxPage(driver, baseUrl);

        textBoxPage
                .openPage()
                .setUserName(testData.userName)
                .setUserEmail(testData.userEmail)
                .setCurrentAddress(testData.currentAddress)
                .setPermanentAddress(testData.permanentAddress)
                .clickSubmit()
                .checkResult("Name", testData.userName)
                .checkResult("Email", testData.userEmail)
                .checkResult("Current Address", testData.currentAddress)
                .checkResult("Permananet Address", testData.permanentAddress);
    }

}
