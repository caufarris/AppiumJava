package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.BasePage;

public class AbasPage extends BasePage {
	
	public boolean confirmaAba1() {
		return existeElementoPorTexto("Este � o conte�do da Aba 1");
	}
	
	public void acessarAba2() {
		clicarPorTexto("ABA 2");
	}
	
	public boolean confirmaAba2 () {
		return existeElementoPorTexto("Este � o conte�do da Aba 2");
	}
	
	

}
