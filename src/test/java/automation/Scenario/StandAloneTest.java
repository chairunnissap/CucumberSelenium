package automation.Scenario;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StandAloneTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void SetUp()  {
        System.out.println("this is before method");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chair\\OneDrive - Badr Interactive\\Documents\\java\\WebAutomation\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(1000));

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void ValidLoginTest() throws InterruptedException{
        // Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ByTagName.tagName("input")));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("this is after method");
        if(driver != null){
            driver.quit();
        }
    }
}
