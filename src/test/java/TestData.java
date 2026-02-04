import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.time.Month;
import java.time.YearMonth;
import java.util.List;

public class TestData {
    Faker faker = new Faker();
    public String userName = faker.name().username();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = RandomUtils.getRandomItemFromArgs("Male", "Female", "Other");
    public String userNumber = String.valueOf(faker.number().randomNumber(10, true));
    public String userBirthMonth = RandomUtils.getRandomItemFromArgs(
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    );
    public String userBirthYear = String.valueOf(RandomUtils.getRandomIntFromRange(1900, 2100));
    public String userBirthDay = getRandomUserBirthDay();
    public String subject = RandomUtils.getRandomItemFromArgs(
            "Maths",
            "Accounting",
            "Arts",
            "Biology",
            "Physics",
            "Chemistry",
            "Commerce",
            "Economics",
            "Civics",
            "Hindi"
    );
    public String userHobby = RandomUtils.getRandomItemFromArgs("Sports", "Reading", "Music");
    public String currentAddress = faker.address().fullAddress();
    public String permanentAddress = faker.address().fullAddress();
    public List<String> states = List.of("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String state = RandomUtils.getRandomItemFromList(states);
    public String city = getCity(state);

    public String getRandomUserBirthDay() {
        int monthLength = YearMonth.of(Integer.parseInt(userBirthYear), Month.valueOf(userBirthMonth.toUpperCase())).lengthOfMonth();
        String randomDay = String.valueOf(RandomUtils.getRandomIntFromRange(1, monthLength));
        randomDay = (randomDay.length() == 1) ? "0" + randomDay : randomDay;
        return randomDay;
    }

    public String getCity(String state) {
        String result = "";
        switch (states.indexOf(state)) {
            case 0:
                result = RandomUtils.getRandomItemFromArgs("Delhi", "Gurgaon", "Noida");
                break;
            case 1:
                result = RandomUtils.getRandomItemFromArgs("Agra", "Lucknow", "Merrut");
                break;
            case 2:
                result = RandomUtils.getRandomItemFromArgs("Karnal", "Panipat");
                break;
            case 3:
                result = RandomUtils.getRandomItemFromArgs("Jaipur", "Jaiselmer");
                break;
        }
        return result;
    }
}
