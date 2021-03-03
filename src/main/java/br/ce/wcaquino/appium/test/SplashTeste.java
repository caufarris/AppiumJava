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
				
		//Verificar que o splash est� sendo exibido
		splash.telaSplashVisivel();
		
		//Aguardar a sa�da do splash
		splash.aguardarSplashSumir();
		
		//Verificar que o formul�rio est� aparecendo
		Assert.assertTrue(splash.existeElementoPorTexto("Formul�rio"));
	}
	

}
