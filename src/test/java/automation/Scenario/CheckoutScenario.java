// package automation.Scenario;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;

// import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;
// import com.webautomation.Page_Factory.Page.DashboardPage;
// import com.webautomation.Page_Factory.Page.LoginPage;

// public class CheckoutScenario {
//     WebDriver driver;
//     WebDriverWait wait;
//     LoginObjectRepository loginPage;

//     @BeforeClass
//     public void setup() {
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.get("https://www.saucedemo.com/");
//         loginPage = new LoginObjectRepository(driver);
//     }

//     @Test
//     public void checkoutScenario() throws InterruptedException{
//         LoginPage loginPage = new LoginPage(driver);
//         loginPage.DoLogin("standard_user", "secret_sauce");
//         Thread.sleep(4000);
//         loginPage.ButtonLogin();

//         DashboardPage dashboardPage = new DashboardPage(driver);
//         dashboardPage.AddToCart("Sauce Labs Backpack","$7.99");
//         Thread.sleep(4000);
//     }

//     @AfterMethod
//     public void tearDown() throws InterruptedException{
//         System.out.println("this is after method");
//         Thread.sleep(4000);
//         if(driver != null){
//             driver.quit();
//         }
//     }
// }
