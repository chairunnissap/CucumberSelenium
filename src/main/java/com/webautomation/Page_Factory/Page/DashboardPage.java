package com.webautomation.Page_Factory.Page;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webautomation.AbstractComponents.AbstractComponents;
import com.webautomation.Page_Factory.Object_Repository.DashboardObjectRepository;

public class DashboardPage extends AbstractComponents{
    private DashboardObjectRepository dashboardObjectRepository;
    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        super(driver);
        this.dashboardObjectRepository = new DashboardObjectRepository(driver);
        this.driver = driver;
    }

    public WebElement getProductByName(String productName){
        waitForVisibilityElement(dashboardObjectRepository.listProduct);
        List<WebElement> product = driver.findElements(dashboardObjectRepository.listProduct);
        return product.stream()
        .filter(item -> {
            String name = item.findElement(dashboardObjectRepository.Name).getText().trim();
            return name.equalsIgnoreCase(productName);
        })
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Product name not found: " + productName));
    }

    public WebElement getProductByPrice(String productPrice){
        waitForVisibilityElement(dashboardObjectRepository.listProduct);
        List<WebElement> product = driver.findElements(dashboardObjectRepository.listProduct);
        return product.stream()
        .filter(item -> {
            String price = item.findElement(dashboardObjectRepository.Price).getText().trim();
            return price.equalsIgnoreCase(productPrice);
        })
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Product price not found: " + productPrice));
    }

    public void AddToCart(String productName, String productPrice){
        WebElement product = getProductByName(productName);
        WebElement price = getProductByPrice(productPrice);
        product.findElement(dashboardObjectRepository.AddProductToCart).click();
        price.findElement(dashboardObjectRepository.AddProductToCart).click();
    }

}
