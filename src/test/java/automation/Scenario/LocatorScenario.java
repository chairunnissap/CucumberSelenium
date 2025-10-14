// package automation.Scenario;

// import java.time.Duration;
// import java.util.List;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.By;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.Select;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.Test;

// public class LocatorScenario {
//     WebDriver driver;
//     WebDriverWait wait;

//     @BeforeMethod
//     public void SetUp()  {
//         System.out.println("this is before method");

//         System.setProperty("webdriver.chrome.driver", "C:\\Users\\chair\\OneDrive - Badr Interactive\\Documents\\java\\WebAutomation\\chromedriver.exe");
//         driver = new ChromeDriver();
//         wait = new WebDriverWait(driver, Duration.ofMillis(1000));

//         driver.manage().window().maximize();
//         driver.manage().deleteAllCookies();

//         driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//     }

//     @Test
//     public void staticDropdown() throws InterruptedException{
//         Thread.sleep(4000);

//         WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//         Select dropdown = new Select(staticDropdown);

//         System.out.println("coba get pertama " +  dropdown.getFirstSelectedOption().getText());
//         System.out.println("coba all option " +  dropdown.getOptions().size());
//         System.out.println("coba get text " +  dropdown.getOptions().get(2).getText());

//         // dropdown by index
//         dropdown.selectByIndex(3);
//         dropdown.selectByVisibleText("AED");
        
//         Thread.sleep(2000);
//         dropdown.selectByValue("INR");
//     }

//     @Test
//     public void dynamicDropdown() throws InterruptedException{
//         driver.findElement(By.id("divpaxinfo")).click();
//         Thread.sleep(2000);

//         for(int i=1;i<5;i++){
//             driver.findElement(By.id("hrefIncAdt")).click();
//         }

//         for(int i=1;i<3;i++){
//             driver.findElement(By.id("hrefIncChd")).click();
//         }

//         for(int i=1;i<2;i++){
//             driver.findElement(By.id("hrefIncInf")).click();
//         }

//         driver.findElement(By.id("btnclosepaxoption")).click();
//         System.out.println("coba get text " +  driver.findElement(By.id("divpaxinfo")).getText());
//         Assert.assertEquals("5 Adult, 2 Child, 1 Infant", "5 Adult, 2 Child, 1 Infant","Jumlah penumpang tidak benar");
//     }

//     @Test
//     public void From() throws InterruptedException{
//         driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//         Thread.sleep(2000);

//         //<a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Adampur (AIP)" value="AIP"> Adampur (AIP)</a>

//         List<WebElement> options = driver.findElements(
//             By.xpath("//a[contains(@onclick, '$CityDropDown') and @value]")
//             );

//         for (WebElement option : options) {
//             System.out.println("City: " + option.getText() + " | Code: " + option.getAttribute("value"));
//             if (option.getText().equalsIgnoreCase("Delhi (DEL)")) {
//                 System.out.println("City "+ option.getText() +" dipilih");
//                 option.click();
//                 break;
//             }
//         }
//     }

//     @Test
//     public void To() throws InterruptedException{

//         driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

//         driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//         Thread.sleep(2000);

//         //<a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Adampur (AIP)" value="AIP"> Adampur (AIP)</a>

//         List<WebElement> options = driver.findElements(
//             By.xpath("//a[contains(@onclick, '$CityDropDown') and @value]")
//             );

//         for (WebElement option : options) {
//             System.out.println("City: " + option.getText() + " | Code: " + option.getAttribute("value"));
//             if (option.getText().equalsIgnoreCase("Delhi (DEL)")) {
//                 System.out.println("City "+ option.getText() +" dipilih");
//                 option.click();
//                 break;
//             }
//         }

//         driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).sendKeys("J");
//         Thread.sleep(2000);

//         //<a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;" text="Jeddah (JED)" value="JED"> Jeddah (JED)</a>

//         List<WebElement> optionsTo = driver.findElements(
//             By.xpath("//a[contains(@onclick, '$CityDropDown') and @value]")
//             );

//         for (WebElement optionTo : optionsTo) {
//             System.out.println("City: " + optionTo.getText() + " | Code: " + optionTo.getAttribute("value"));
//             if (optionTo.getText().equals("Jeddah (JED)")) {
//                 System.out.println("City "+ optionTo.getText() +" dipilih");
//                 optionTo.click();
//                 break;
//             }
//         }
//     }

//     @Test
//     public void handleAutoSuggestDropdown() throws InterruptedException {
//         driver.findElement(By.id("autosuggest")).sendKeys("Ind");
//         Thread.sleep(2000);

//         List<WebElement> options = driver.findElements(By.cssSelector("ul#ui-id-1 li.ui-menu-item a"));
//         System.out.println(options.size());

//         for (WebElement option : options) {
//             String country = option.getText();
//             System.out.println(country);
//             if (country.equalsIgnoreCase("Indonesia")) {
//                 option.click();
//                 break;
//             }
//         }
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
