package pages;

//import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static pages.commonSteps.test;
import static stepdefinitions.StepDefinitions.driver;


public class logInPage {


    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void setUpLoginPage(){
        driver.get("https://the-internet.herokuapp.com/login");
    }


    public static void enterIntoUserNameTextField(String username){
        try{
            WebElement userName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));
            userName.sendKeys(username);
            //test.log(Status.INFO, "Username Entered Suucessfully");
        } catch (Exception e){
            throw new Error("Couldn't Find Username Text Field");
        }
    }

    public static void enterIntoPasswordTestIField(String password){

        try{
            WebElement passWord = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
            passWord.sendKeys(password);
            //test.log(Status.INFO, "Password Entered Successfully");
        } catch (Exception e){
            throw new Error("Couldn't Find Password Text Field");
        }
    }

    public static void clickOnLogInButton(){
        try{
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='radius']")));
            loginButton.click();
            //test.log(Status.INFO, "Log In button clicked Successfully.");
        } catch(Exception e){
            throw new Error("Couldn't Find LogIn Button");
        }
    }

    public static void userLoginSuccessful(){
        String expectedWord = "Logout";
        String actualWord = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).getText();
        Assert.assertEquals(expectedWord,actualWord);
        //test.log(Status.INFO, "User Logged In Successfully");
    }

    public static void userLogOut() {
        try{
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/a")));
            logoutButton.click();
            String expectedWord = "Login Page";
            String actualWord = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2")).getText();
            Assert.assertEquals(expectedWord,actualWord);
            //test.log(Status.INFO, "Log In button clicked Successfully.");
        } catch(Exception e){
            throw new Error("Couldn't Log Out");
        }
    }
}
