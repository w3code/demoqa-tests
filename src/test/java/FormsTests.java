import org.junit.jupiter.api.Test;
import pages.FormPage;

public class FormsTests extends TestBase {


    @Test
    void practiseFormRegistrationTest() {
        FormPage formPage = new FormPage(driver, baseUrl);

        formPage.openPage("/automation-practice-form")
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.userBirthDay, testData.userBirthMonth, testData.userBirthYear)
                .setSubject(testData.subject)
                .setUserHobby(testData.userHobby)
                .uploadPicture()
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submitClick()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.userBirthDay + " " + testData.userBirthMonth + "," + testData.userBirthYear)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.userHobby)
                .checkResult("Picture", "at.jpg")
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state + " " + testData.city)
                .closeModal();


    }

}
