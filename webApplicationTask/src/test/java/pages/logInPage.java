package pages;

//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Status;
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
import static stepdefinitions.StepDefinitions.*;


public class logInPage {


    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public static void setUpLoginPage(){

        driver.get(BASE_URL+"/login");
        if ((BASE_URL + "/login").equals(driver.getCurrentUrl())){
            test.log(Status.INFO,"Log In page opened successfully");
        } else{
            test.log(Status.FAIL,"Cannot open Log In page");
        }

    }


    public static void enterIntoUserNameTextField(String username){
        try{
            WebElement userName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));
            userName.sendKeys(username);
        } catch (Exception e){
            throw new Error("Couldn't Find Username Text Field");
        }
    }

    public static void enterIntoPasswordTestIField(String password){

        try{
            WebElement passWord = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
            passWord.sendKeys(password);
        } catch (Exception e){
            throw new Error("Couldn't Find Password Text Field");
        }
    }

    public static void clickOnLogInButton(){
        try{
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='radius']")));
            loginButton.click();
            if ((BASE_URL + "/secure").equals(driver.getCurrentUrl())){
                test.log(Status.INFO, "Log In button clicked Successfully.");
            }
            else {
                test.log(Status.FAIL,"Cannot Log In");
            }

        } catch(Exception e){
            throw new Error("Couldn't Find LogIn Button");
        }
    }

    public static void userLoginSuccessful(){
        String expectedWord = "Logout";
        String actualWord = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).getText();
        Assert.assertEquals(expectedWord,actualWord);
        test.log(Status.INFO, "User Logged In Successfully");
    }

    public static void userLogOut() {
        try{
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/a")));
            logoutButton.click();
            String expectedWord = "Login Page";
            String actualWord = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2")).getText();
            Assert.assertEquals(expectedWord,actualWord);
            if ((BASE_URL + "/login").equals(driver.getCurrentUrl())){
                test.log(Status.INFO, "Log Out button clicked Successfully.");
            } else{
                test.log(Status.FAIL, "Cannot Log Out");
            }

        } catch(Exception e){
            throw new Error("Couldn't Log Out");
        }
    }
}
