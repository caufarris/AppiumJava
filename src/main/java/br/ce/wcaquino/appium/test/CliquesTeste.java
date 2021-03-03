package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.CliquesPage;
import br.ce.wcaquino.appium.page.MenuPage;


public class CliquesTeste extends BaseTest {
	
	private static MenuPage menu = new MenuPage();
	private CliquesPage clique = new CliquesPage();
	
	
	
	@BeforeClass
	public static void setup() {
	menu.acessarCliques();
	}
	
	@Test
	public void realizarCliqueLongo() {
		
		
		//Clique Longo
		clique.clicarLongo();
		Assert.assertEquals("Clique Longo", clique.obterTextoCampo());	
		
	}
	
	@Test
	public void realizarCliqueDuplo() {
		clique.clicarPorTexto("Clique duplo");
		clique.clicarPorTexto("Clique duplo");
		
		Assert.assertEquals("Duplo Clique", clique.obterTextoCampo());
		
	}

}
