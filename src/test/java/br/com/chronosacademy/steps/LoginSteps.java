package br.com.chronosacademy.steps;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.enums.Browser;
import br.com.chronosacademy.pages.LoginPage;
import br.com.chronosacademy.pages.NewAccountPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginSteps {
    LoginPage loginPage;
    NewAccountPage newAccountPage;
    String username;

    @Before
    public void iniciaNavegador(Scenario cenario){
        new Driver(Browser.CHROME);
        Driver.setNomeCenario(cenario.getName());
        Driver.criaDiretorio();
    }

    @After
    public void fechaNavegador(Scenario cenario) throws IOException {
        if (cenario.isFailed()){
            Driver.printScreen("erro no cenario");
        }

        Driver.getDriver().quit();

    }

    @Dado("que a modal esteja sendo exibida")
    public void queAModalEstejaSendoExibida() {
        Driver.getDriver().get("https://www.advantageonlineshopping.com/");
        loginPage = new LoginPage();
        loginPage.clickBtnLogin();
        loginPage.visibilityOfBtnFechar();
        loginPage.aguardaLoader();
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
        newAccountPage = new NewAccountPage();

        Assert.assertEquals("CREATE ACCOUNT", newAccountPage.getTextNewAccount());
    }

    @Quando("os campos de login forem preenchidos com os valores")
    public void osCamposDeLoginForemPreenchidosComOsValores(Map<String, String> map) throws IOException {
        username = map.get("usuario");
        String password = map.get("senha");
        boolean remember = Boolean.parseBoolean(map.get("remember"));

        loginPage.setInpUserName(username);
        loginPage.setInpPassword(password);

        if (remember) loginPage.clickInpRemember();

        Driver.printScreen("preenchimento dos campos de login");

    }

    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clickBtnSignIn();
    }

    @Entao("deve ser possivel logar no sistema")
    public void deveSerPossivelLogarNoSistema() throws IOException {
        Assert.assertEquals(username, loginPage.getTextLogado());
        Driver.printScreen("logado no sistema");
    }

    @Entao("o sistema devera exibir uma mensagem de erro")
    public void oSistemaDeveraExibirUmaMensagemDeErro() {
        Assert.assertEquals("Incorrect user name or password.",loginPage.getErroLogin());
    }

    @Entao("o botao sign in deve permanecer desabilitado")
    public void oBotaoSignInDevePermanecerDesabilitado() {
        boolean enabled = loginPage.isBtnSignIn();
        Assert.assertFalse(enabled);
    }
}
