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
		
		//Clicar Op��o 1 para a direita
		swipe.swipeElementRight("Op��o 1");
		
		//Clicar Op��o +
		swipe.clicarBotaoMais();
		
		//Verificar op��o 1 + presente
		Assert.assertTrue(swipe.existeElementoPorTexto("Op��o 1 (+)"));
		
		//Clicar Op��o 4 direita
		swipe.swipeElementRight("Op��o 4");
		
		//Clicar Op��o -
		swipe.clicarPorTexto("(-)");
		
		//Verificar op��o 4 - presente
		Assert.assertTrue(swipe.existeElementoPorTexto("Op��o 4 (-)"));
				
		//Clicar Op��o 5 esquerda
		swipe.swipeElementLeft("Op��o 5 (-)");
		
		//Verificar op��o 4 - presente
			Assert.assertTrue(swipe.existeElementoPorTexto("Op��o 5"));
	}

}
