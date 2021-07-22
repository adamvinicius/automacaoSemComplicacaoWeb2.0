package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CursoMap {
    @FindBy(xpath = "//section[2]//h2")
    public WebElement h2Titulo;
}
