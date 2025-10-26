package hook;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static WebDriver driver;
    LoginObjectRepository loginPage;

    @Before
    public void SetUp() throws IOException{
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\chair\\OneDrive - Badr Interactive\\Documents\\java\\WebAutomation\\webautomation\\src\\main\\resources\\GlobalData.properties");
        properties.load(fileInputStream);

        String BrowserName = properties.getProperty("browser");
        if (BrowserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if(BrowserName.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Users\\chair\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
            driver = new FirefoxDriver(options);
        }else{
            System.out.println("Masukkan Browser");
        }

        
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        loginPage = new LoginObjectRepository(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void TearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver GetDriver(){
        return driver;
    }
}
