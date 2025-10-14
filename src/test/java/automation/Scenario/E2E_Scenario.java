// package automation.Scenario;

// import java.time.Duration;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.openqa.selenium.By;
// import org.openqa.selenium.By.ByTagName;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.Test;

// public class E2E_Scenario {
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

//         driver.get("https://www.saucedemo.com/");
//     }

//     @Test
//     public void Login() throws InterruptedException{
//         Thread.sleep(2000);
//         wait.until(ExpectedConditions.visibilityOfElementLocated(ByTagName.tagName("input")));

//         driver.findElement(By.id("user-name")).sendKeys("standard_user");
//         driver.findElement(By.id("password")).sendKeys("secret_sauce");
        
//         driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
//         Thread.sleep(4000);
//     }

//     @Test
//     public void AddProductToCart() throws InterruptedException{
//         Thread.sleep(2000);
//         wait.until(ExpectedConditions.visibilityOfElementLocated(ByTagName.tagName("input")));

//         driver.findElement(By.id("user-name")).sendKeys("standard_user");
//         driver.findElement(By.id("password")).sendKeys("secret_sauce");
//         driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
//         Thread.sleep(4000);

//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//         WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
//             By.id("add-to-cart-sauce-labs-backpack")
//         ));
//         addToCartBtn.click();

//         Thread.sleep(2000);
//         String buttonText = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
//         Assert.assertEquals(buttonText, "Remove", "Produk berhasil ditambahkan ke cart");
//     }

//     @Test
//     public void AddMoreProductToCart() throws InterruptedException{
//         Thread.sleep(2000);
//         wait.until(ExpectedConditions.visibilityOfElementLocated(ByTagName.tagName("input")));

//         driver.findElement(By.id("user-name")).sendKeys("standard_user");
//         driver.findElement(By.id("password")).sendKeys("secret_sauce");
//         driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
//         Thread.sleep(4000);

//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));

//         driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
//         Thread.sleep(2000);
//         driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

//         WebElement removeBackpack = driver.findElement(By.id("remove-sauce-labs-backpack"));
//         WebElement removeJacket = driver.findElement(By.id("remove-sauce-labs-fleece-jacket"));

//         if (removeBackpack.isDisplayed() && removeJacket.isDisplayed()) {
//             System.out.println("Kedua produk berhasil ditambahkan ke cart");
//         } else {
//             System.out.println("Gagal menambahkan produk ke cart");
//         }

//     }

//     @Test
//     public void AddProductToCartStream() throws InterruptedException{
//         Thread.sleep(2000);
//         wait.until(ExpectedConditions.visibilityOfElementLocated(ByTagName.tagName("input")));

//         driver.findElement(By.id("user-name")).sendKeys("standard_user");
//         driver.findElement(By.id("password")).sendKeys("secret_sauce");
//         driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
//         Thread.sleep(4000);

//         List<WebElement> options = driver.findElements(By.cssSelector("div.inventory_item"));
//         System.out.println(options.size());

//         // for (WebElement item : options) {
//         //     String name = item.findElement(By.cssSelector(".inventory_item_name")).getText();
//         //     String price = item.findElement(By.cssSelector(".inventory_item_price")).getText();
//         //     WebElement button = item.findElement(By.cssSelector("button.btn_inventory"));
            
//         //     if (name.equalsIgnoreCase("Sauce Labs Backpack")|| price.equals("$7.99")) {
//         //         button.click();
//         //     }
//         // }

//         options.stream()
//             .filter(item -> {
//                 String name = item.findElement(By.cssSelector(".inventory_item_name")).getText();
//                 String price = item.findElement(By.cssSelector(".inventory_item_price")).getText();
//                 return name.equalsIgnoreCase("Sauce Labs Backpack") || price.equals("$7.99");
//             })
//             .forEach(item -> {
//                 WebElement button = item.findElement(By.cssSelector("button.btn_inventory"));
//                 button.click();
//             });
//         Thread.sleep(2000);

//     }

//     @Test
//     public void CheckoutProduct() throws InterruptedException{
//         Thread.sleep(2000);
//         wait.until(ExpectedConditions.visibilityOfElementLocated(ByTagName.tagName("input")));

//         driver.findElement(By.id("user-name")).sendKeys("standard_user");
//         driver.findElement(By.id("password")).sendKeys("secret_sauce");
//         driver.findElement(By.cssSelector(".submit-button.btn_action")).click();
//         Thread.sleep(4000);

//         List<WebElement> options = driver.findElements(By.cssSelector("div.inventory_item"));
//         System.out.println(options.size());

//         options.stream()
//             .filter(item -> {
//                 String name = item.findElement(By.cssSelector(".inventory_item_name")).getText();
//                 String price = item.findElement(By.cssSelector(".inventory_item_price")).getText();
//                 return name.equalsIgnoreCase("Sauce Labs Backpack") || price.equals("$7.99");
//             })
//             .forEach(item -> {
//                 WebElement button = item.findElement(By.cssSelector("button.btn_inventory"));
//                 button.click();
//             });
//         Thread.sleep(2000);
        
//         WebElement cartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
//         cartLink.click();
//         Thread.sleep(2000);

//         //verifikasi produk di cart
//         List<WebElement> optionVerif = driver.findElements(By.cssSelector("[data-test='inventory-item']"));

//         List<String> productNames = optionVerif.stream().map(item -> {
//             String name = item.findElement(By.cssSelector("[data-test='inventory-item-name']")).getText();
//             String price = item.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText();
//             String qty = item.findElement(By.cssSelector("[data-test='item-quantity']")).getText();

//             System.out.println("Nama: " + name + " | Harga: " + price + " | Qty: " + qty);
//             return name;
//         }).collect(Collectors.toList());

//         Assert.assertTrue(productNames.contains("Sauce Labs Backpack"), "Sauce Labs Backpack tidak ditemukan di cart!");
//         Assert.assertTrue(productNames.contains("Sauce Labs Onesie"), "Sauce Labs Onesie tidak ditemukan di cart!");
//         Thread.sleep(2000);

//         driver.findElement(By.xpath("//button[@data-test='checkout']")).click();
//         Thread.sleep(2000);

//         //Isi Informasi
//         driver.findElement(By.id("first-name")).sendKeys("Chairun");
//         driver.findElement(By.id("last-name")).sendKeys("Puspitasari");
//         driver.findElement(By.id("postal-code")).sendKeys("13810");
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//input[@id='continue']")).click();

//         //Checkout Overview
//         List<WebElement> optionsOverview = driver.findElements(By.cssSelector("[data-test='inventory-item']"));
        
//         double totalCalculated = optionsOverview.stream()
//             .mapToDouble(item -> {
//                 String priceText = item.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText();
//                 // hapus tanda $ dan ubah ke double
//                 return Double.parseDouble(priceText.replace("$", ""));
//             })
//             .sum();
//         System.out.println("Total harga dihitung: $" + totalCalculated);

//         String pricetotalText = driver.findElement(By.cssSelector("[data-test='subtotal-label']")).getText();
//         // Contoh: "Item total: $37.98"
//         double ItemTotal = Double.parseDouble(pricetotalText.replace("Item total: $", "").trim());
//         System.out.println("PriceTotal dari item total: $" + ItemTotal);

//         // Overview total harga benar
//         Assert.assertEquals(ItemTotal, totalCalculated, "Total Harga tidak sesuai!");
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//button[@id='finish']")).click();
//         Thread.sleep(2000);

//         //Sampai muncul tulisan thank you
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//         WebElement confirmationMessage = wait.until(
//                 ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='complete-header']"))
//         );
//         String actualMessage = confirmationMessage.getText();
//         Assert.assertEquals(actualMessage, "Thank you for your order!");
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
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
