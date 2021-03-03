package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SwipeElementPage;

public class SwipeElementTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SwipeElementPage swipe = new SwipeElementPage();
	
	@Test
	
	public void swipeElement() {
		//Clicar no Swipe List
		menu.clicarSwipeList();
		
		//Clicar Opção 1 para a direita
		swipe.swipeElementRight("Opção 1");
		
		//Clicar Opção +
		swipe.clicarBotaoMais();
		
		//Verificar opção 1 + presente
		Assert.assertTrue(swipe.existeElementoPorTexto("Opção 1 (+)"));
		
		//Clicar Opção 4 direita
		swipe.swipeElementRight("Opção 4");
		
		//Clicar Opção -
		swipe.clicarPorTexto("(-)");
		
		//Verificar opção 4 - presente
		Assert.assertTrue(swipe.existeElementoPorTexto("Opção 4 (-)"));
				
		//Clicar Opção 5 esquerda
		swipe.swipeElementLeft("Opção 5 (-)");
		
		//Verificar opção 4 - presente
			Assert.assertTrue(swipe.existeElementoPorTexto("Opção 5"));
	}

}
