package br.com.chronosacademy.pages;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.maps.EditAccountMap;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {
    EditAccountMap editAccountMap;

    public EditAccountPage(){
        editAccountMap = new EditAccountMap();
        PageFactory.initElements(Driver.getDriver(), editAccountMap);
    }

    public void setInpFirstName(String firstName){
        Driver.visibilityOf(editAccountMap.inpFirstName);
        editAccountMap.inpFirstName.sendKeys(firstName);
    }

    public void setInpLastName(String lastName){
        editAccountMap.inpLastName.sendKeys(lastName);
    }

    public void clickBtnSave(){
        editAccountMap.btnSave.click();
    }
}
