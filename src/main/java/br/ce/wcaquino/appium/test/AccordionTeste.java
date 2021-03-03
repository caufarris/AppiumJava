package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AccordionPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage accordion = new AccordionPage();
	
	@Test
	public void interagirComAccordion() {
		//Acessar Accordion
		menu.acessarAccordion();
		
		//Clicar na op��o 1
		accordion.selecionarOpcao1();
		
		//Verificar texto op��o 1
		Assert.assertEquals("Esta � a descri��o da op��o 1", accordion.obterTextoOpcao1());
	}

}
