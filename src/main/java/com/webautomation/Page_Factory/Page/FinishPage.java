package com.webautomation.Page_Factory.Page;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webautomation.Page_Factory.Object_Repository.FinishObjectRepository;

public class FinishPage {
    private FinishObjectRepository finishObjectRepository;
    private WebDriver driver;

    public FinishPage(WebDriver driver) {
        this.driver = driver;
        this.finishObjectRepository = new FinishObjectRepository(driver);
        PageFactory.initElements(driver, this);
    }

    public String Finish(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmationMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(finishObjectRepository.FinishTeks)
        );
        return confirmationMessage.getText();
    }

    public void BackToProduct(){
        driver.findElement(finishObjectRepository.BackToProduct).click();
    }
}
