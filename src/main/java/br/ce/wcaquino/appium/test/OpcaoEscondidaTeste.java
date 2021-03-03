package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.MenuPage;

public class OpcaoEscondidaTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private BasePage page = new BasePage();
	
	
	@Test
	public void encontrarOpcaoEscondida() {
		
		//Scroll Down
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
				
		page.scrollDown();
		
		//Clicar menu
		page.clicarPorTexto("Op��o bem escondida");
		
		//Verificar mensagem
		Assert.assertEquals("Voc� achou essa op��o", menu.obterMensagemAlerta());
		
		//Clicar em sair
		menu.clicarPorTexto("OK");
	}

}
