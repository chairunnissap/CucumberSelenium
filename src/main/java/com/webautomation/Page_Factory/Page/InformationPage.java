package com.webautomation.Page_Factory.Page;
import org.openqa.selenium.WebDriver;
import com.webautomation.Page_Factory.Object_Repository.InformationObjectRepository;

public class InformationPage {
    private InformationObjectRepository informationObjectRepository;

    public InformationPage(WebDriver driver) {
        this.informationObjectRepository = new InformationObjectRepository(driver);
    }

    public void DoContinue(String firstname, String lastname, String PostalCode){
        informationObjectRepository.FirstName.sendKeys(firstname);
        informationObjectRepository.LastName.sendKeys(lastname);
        informationObjectRepository.PostalCode.sendKeys(PostalCode);
        informationObjectRepository.ContinueButton.click();
    }
}
