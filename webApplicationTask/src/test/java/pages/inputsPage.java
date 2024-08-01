package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stepdefinitions.StepDefinitions.*;

public class inputsPage {

    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void setUpInputPage(){
        driver.get("https://the-internet.herokuapp.com/inputs");
        if ((BASE_URL + "/inputs").equals(driver.getCurrentUrl())){
            test.log(Status.INFO,"Inputs page opened successfully");
        } else{
            test.log(Status.FAIL,"Cannot open Inputs page");
        }


    }

    public static void fillForm(String input){
        try{
            WebElement inputTextField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div/div/input")));
            inputTextField.sendKeys(input);
        } catch (Exception e){
            throw new Error("Couldn't find Input Form.");
        }
    }
}
