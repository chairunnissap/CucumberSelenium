package automation.Scenario;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Iterator;

public class HandleWindow {
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

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
    }

    @Test
    public void handleWindow() throws InterruptedException {
        WebElement link = driver.findElement(By.cssSelector("a.blinkingText"));
        Thread.sleep(2000);
        link.click();
        
        // Pindah ke tab baru
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section.page-title h1")));

        Assert.assertEquals(heading.getText(), "DOCUMENTS REQUEST", "Judul halaman tidak sesuai!");
        Thread.sleep(2000);
        driver.switchTo().window(parentId);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException{
        System.out.println("this is after method");
        Thread.sleep(4000);
        if(driver != null){
            driver.quit();
        }
    }
}
