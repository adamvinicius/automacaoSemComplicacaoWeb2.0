package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;

    @Before
    public void iniciaNavegador(){
        new Driver(Browser.CHROME);
    }

    @After
    public void fechaNavegador(){
        Driver.getDriver().quit();
    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        Driver.getDriver().get("https://www.advantageonlineshopping.com/");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();

    }
    @Quando("for realizado um clique fora da modal")
    public void forRealizadoUmCliqueForaDaModal() {
        loginPage.clickDivFechaModal();
    }
    @Entao("a janela modal deve ser fechada")
    public void aJanelaModalDeveSerFechada() throws Exception {
        try {
            loginPage.invisibilityOfBtnFechar();
        } catch (Exception e){
            throw new Exception("A janela modal não foi fechada");
        }




    }

    @Quando("for realizado um clique icone de fechar da modal")
    public void forRealizadoUmCliqueIconeDeFecharDaModal() {
        loginPage.clickBtnFechar();
    }

    @Quando("for realizado um clique em Create New Account")
    public void forRealizadoUmCliqueEmCreateNewAccount() {
        loginPage.clickLinkCreateAccount();
    }

    @Entao("a pagina Create Account deve ser exibida")
    public void aPaginaCreateAccountDeveSerExibida() {
        
    }

    @Quando("os campos de login forem preenchidos com os valores")
    public void osCamposDeLoginForemPreenchidosComOsValores(Map<String, String> map) {
        String username = map.get("usuario");
        String password = map.get("senha");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);

        if (remember) loginPage.clickInpRemember();





    }

    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickBtnSignIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() {
        
    }

    @Entao("o sistema devera exibir uma mensagem de erro")
    public void oSistemaDeveraExibirUmaMensagemDeErro() {
        
    }

    @Entao("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        Assert.assertFalse(enabled);
    }
}
