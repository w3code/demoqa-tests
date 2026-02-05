import org.junit.jupiter.api.Test;
import pages.CheckBoxPage;
import pages.TextBoxPage;

public class ElementsTests extends TestBase {
    @Test
    void textBoxTest() {
        TextBoxPage textBoxPage = new TextBoxPage(driver, baseUrl);

        textBoxPage
                .openPage("/text-box")
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

    @Test
    void checkBoxExpandTest() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver, baseUrl);

        checkBoxPage
                .openPage("/checkbox")
                .clickExpandAll()
                .isExpanded();
    }

    @Test
    void checkBoxCollapseTest() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver, baseUrl);

        checkBoxPage
                .openPage("/checkbox")
                .clickExpandAll()
                .clickCollapseAll()
                .isCollapsed();
    }
}
