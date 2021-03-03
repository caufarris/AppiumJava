package br.ce.wcaquino.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private WebViewPage webview = new WebViewPage();

	@Test
	public void fazerLogin() {
		// Acessar menu
		menu.acessarSBHibrido();
		aguardar(5000);
		webview.entrarContextoWeb();

		// Preencher e-mail
		webview.setEmail("c@f");
		
		// senha
		webview.setSenha("cf");
		// entrar
		webview.entrar();
		
		//Verificar
		Assert.assertEquals("Bem vindo, Claudia!", webview.verMensagem());
	}
	
	@After
	public void tearDown() {
		webview.sairContextoWeb();
	}
}
