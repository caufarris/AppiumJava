package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;

public class SwipeTeste extends BaseTest {
	
	MenuPage menu = new MenuPage();
	
	@Test
	public void realizarSwipe() {
		menu.acessarSwipe();
		
		//Verificar o texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		//Swipe para a direita
		menu.swipeRight();
		
		//Verificar o texto 'E veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		
		//Clicar botão direita
		menu.clicarPorTexto(">");
		
		//Verificar o texto 'Chegar até o fim'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim"));
		
		//Swipe esquerda
		menu.swipeLeft();
		
		//Clicar botão esquerda
		menu.clicarPorTexto("<");
		
		//Verificar o texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}

}
