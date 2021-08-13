package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(css = "#menuUser")
    public WebElement btnLogin; //click
    public WebElement btnFechar; //click
    public WebElement divFechaModal; //click
    public WebElement inpUserName; //set
    public WebElement inpPassword; //set
    public WebElement inpRemember; //click
    public WebElement btnSignIn; //click
    public WebElement linkCreateAccount; //click


}
