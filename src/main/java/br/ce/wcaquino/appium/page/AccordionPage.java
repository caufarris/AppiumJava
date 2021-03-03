package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class AccordionPage extends BasePage {
	
	public void selecionarOpcao1() {
		clicarPorTexto("Opção 1");
	}
	
	public String obterTextoOpcao1() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Esta é a descrição')]"));
	}

}
