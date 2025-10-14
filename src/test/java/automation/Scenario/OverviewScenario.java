// package automation.Scenario;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;
// import com.webautomation.Page_Factory.Object_Repository.LoginObjectRepository;
// import com.webautomation.Page_Factory.Page.CartPage;
// import com.webautomation.Page_Factory.Page.DashboardPage;
// import com.webautomation.Page_Factory.Page.InformationPage;
// import com.webautomation.Page_Factory.Page.LoginPage;
// import com.webautomation.Page_Factory.Page.OverviewPage;

// public class OverviewScenario {
//     WebDriver driver;
//     WebDriverWait wait;
//     LoginObjectRepository loginPage;
//     OverviewPage overviewPage;

//     @BeforeClass
//     public void setup() {
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.get("https://www.saucedemo.com/");
//         loginPage = new LoginObjectRepository(driver);
//     }

//     @Test
//     public void overviewScenario() throws InterruptedException{
//         LoginPage loginPage = new LoginPage(driver);
//         loginPage.DoLogin("standard_user", "secret_sauce");
//         Thread.sleep(4000);
//         loginPage.ButtonLogin();

//         DashboardPage dashboardPage = new DashboardPage(driver);
//         dashboardPage.AddToCart("Sauce Labs Backpack","$7.99");
//         Thread.sleep(4000);

//         CartPage cartPage = new CartPage(driver);
//         cartPage.GoToCart();
//         Assert.assertTrue(cartPage.VerifyName("Sauce Labs Backpack").isDisplayed());
//         Assert.assertTrue(cartPage.VerifyPrice("$7.99").isDisplayed());
//         Assert.assertTrue(cartPage.VerifyQty("1").isDisplayed());
//         Assert.assertTrue(
//             cartPage.VerifyName("Sauce Labs Backpack").getText().contains("Sauce Labs Backpack"),
//             "Sauce Labs Backpack tidak ditemukan di cart!"
//         );
//         Assert.assertTrue(
//             cartPage.VerifyName("Sauce Labs Onesie").getText().contains("Sauce Labs Onesie"),
//             "Sauce Labs Onesie tidak ditemukan di cart!"
//         );
//         Thread.sleep(2000);
//         cartPage.VerifyProductInCart("Sauce Labs Backpack", "$7.99", "1");
//         Thread.sleep(2000);

//         InformationPage informationPage = new InformationPage(driver);
//         informationPage.DoContinue("Chairun", "Nissa","Puspitasari");
//         Thread.sleep(4000);
        
//         OverviewPage overviewPage = new OverviewPage(driver);
//         Thread.sleep(2000);
//         double totalCalculated = overviewPage.getTotalCalculated();
//         System.out.println("Total harga dihitung: $" + totalCalculated);

//         String pricetotalText = overviewPage.PricetotalText();
//         // Contoh: "Item total: $37.98"
//         double ItemTotal = Double.parseDouble(pricetotalText.replace("Item total: $", "").trim());
//         System.out.println("PriceTotal dari item total: $" + ItemTotal);

//         // Overview total harga benar
//         Assert.assertEquals(ItemTotal, totalCalculated, "Total Harga tidak sesuai!");
//         Thread.sleep(2000);
//         overviewPage.Finish();
//         Thread.sleep(2000);
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
