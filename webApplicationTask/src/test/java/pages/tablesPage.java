package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static stepdefinitions.StepDefinitions.*;

public class tablesPage {

    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void setUpTablesPage(){
        driver.get("https://the-internet.herokuapp.com/tables");
        if ((BASE_URL + "/tables").equals(driver.getCurrentUrl())){
            test.log(Status.INFO,"Tables page opened successfully");
        } else{
            test.log(Status.FAIL,"Cannot open Tables page");
        }

    }


    public static void extractDataformTable(){
        try{
            WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"table1\"]")));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("th"));
                for (WebElement cell : cells) {
                    System.out.println(cell.getText());
                }
            }
        } catch (Exception e){
            throw new Error("Couldn't find table");
        }

    }
}


