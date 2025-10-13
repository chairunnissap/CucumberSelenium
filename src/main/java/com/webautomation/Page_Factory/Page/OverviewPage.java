package com.webautomation.Page_Factory.Page;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.Page_Factory.Object_Repository.OverviewObjectRepository;

public class OverviewPage {
    private OverviewObjectRepository overviewObjectRepository;
    private WebDriver driver;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        this.overviewObjectRepository = new OverviewObjectRepository(driver);
        PageFactory.initElements(driver, this);
    }

    public double getTotalCalculated() {

        List<WebElement> optionsOverview = overviewObjectRepository.listProductOverview;
        double totalCalculated = optionsOverview.stream()
            .mapToDouble(item -> {
                String priceText = item.findElement(overviewObjectRepository.Price).getText();
                return Double.parseDouble(priceText.replace("$", ""));
            })
            .sum();

        return totalCalculated;
    }

    public String PricetotalText() throws InterruptedException{
        return driver.findElement(overviewObjectRepository.PriceTotal).getText();
    }
    
    public void Finish() {
        driver.findElement(overviewObjectRepository.Finish).click();
    }
}
