package br.com.chronosacademy.pages;

import br.com.chronosacademy.maps.CursoMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CursoPage {
    private WebDriver driver;
    private CursoMap cursoMap;

    public CursoPage(WebDriver driver) {
        this.driver = driver;
        cursoMap = new CursoMap();
        PageFactory.initElements(driver, cursoMap);
    }

    public String getTitulo2() {

        return cursoMap.h2Titulo.getText();
    }
}
