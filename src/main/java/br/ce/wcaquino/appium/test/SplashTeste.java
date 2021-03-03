package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;

public class SplashTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private SplashPage splash = new SplashPage();
	
	@Test
	public void aguardarSplashSumir() {
		//Acessar menu splash
		menu.acessarSplash();
				
		//Verificar que o splash está sendo exibido
		splash.telaSplashVisivel();
		
		//Aguardar a saída do splash
		splash.aguardarSplashSumir();
		
		//Verificar que o formulário está aparecendo
		Assert.assertTrue(splash.existeElementoPorTexto("Formulário"));
	}
	

}
