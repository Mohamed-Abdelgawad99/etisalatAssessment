package stepdefinitions;

//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.inputsPage;
import pages.logInPage;
import pages.tablesPage;

import java.io.File;
import java.io.IOException;

//import static pages.commonSteps.test;

public class StepDefinitions {

    public static WebDriver driver;
    static ExtentReports report;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();
    public static final String BASE_URL = "https://the-internet.herokuapp.com";

    @BeforeTest
    public static void setUp(){
        ExtentSparkReporter spark = new ExtentSparkReporter("target/test-reports/Spart.html");
        extent.attachReporter(spark);
        driver = new ChromeDriver();
    }



    @Test(priority = 1)
    public void validateLoIn() {
        test = extent.createTest("Log In page Test Case");
        logInPage.setUpLoginPage();
        logInPage.enterIntoUserNameTextField("tomsmith ");
        logInPage.enterIntoPasswordTestIField("SuperSecretPassword!");
        logInPage.clickOnLogInButton();
        logInPage.userLoginSuccessful();
        logInPage.userLogOut();

    }

    @Test(priority = 2)
    public void tableData(){
        test = extent.createTest("Tables page data extraction test");
        tablesPage.setUpTablesPage();
        tablesPage.extractDataformTable();
    }

    @Test(priority = 3)
    public void inputFrom(){
        test = extent.createTest("Inputs page fill form test");
        inputsPage.setUpInputPage();
        inputsPage.fillForm("4555");
    }

    @AfterSuite
    public void cleanUp(){
        extent.flush();
    }

//    @Given("User Opens Log in Page")
//    public void user_opens_log_in_page() {
//        logInPage.setUpLoginPage();
//        test.log(Status.INFO, "Login page opened successfully.");
//
//    }
//
//
//    @And("User writes his username {string}")
//    public void userWritesHisStringUsername(String userName ) {
//        logInPage.enterIntoUserNameTextField(userName);
//        test.log(Status.INFO, "Entered username: " + userName);
//
//    }
//
//    @And("User writes his password {string}")
//    public void user_writes_his_password(String passWord) {
//        logInPage.enterIntoPasswordTestIField(passWord);
//        test.log(Status.INFO, "Entered password.");
//
//    }
//
//    @And("Clicks on Log In button")
//    public void clicks_on_log_in_button() {
//        logInPage.clickOnLogInButton();
//        test.log(Status.INFO, "Clicked on login button.");
//
//    }
//
//    @Then("User Logs In Successfully")
//    public void user_logs_in_successfully() {
//        logInPage.userLoginSuccessful();
//        test.log(Status.PASS, "User logged in successfully.");
//
//    }
//


}
