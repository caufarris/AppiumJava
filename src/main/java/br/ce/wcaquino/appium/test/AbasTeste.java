package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AbasPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AbasTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbasPage abas = new AbasPage();
	
	@Test
	
	public void interagirComAbas() {
		
		//Acessar as abas
		menu.acessarAbas();
	
		//Verificar que está na aba 1
		Assert.assertTrue(abas.confirmaAba1());
	
		//Acessar a aba 2
		abas.clicarPorTexto("ABA 2");
	
		//Verificar que está na aba 2
		Assert.assertTrue(abas.confirmaAba2());
		
	}
}
