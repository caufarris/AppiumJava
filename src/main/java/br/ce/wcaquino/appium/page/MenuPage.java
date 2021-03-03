package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;

public class MenuPage extends BasePage {

	public void acessarFormulario() {
		clicarPorTexto("Formulário");

	}

	public void acessarSplash() {
		clicarPorTexto("Splash");

	}

	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}

	public void acessarAbas() {
		clicarPorTexto("Abas");
	}

	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}

	public void acessarCliques() {
		clicarPorTexto("Cliques");
	}

	public void acessarSwipe() {
		clicarPorTexto("Swipe");
	}

	public void clicarSwipeList() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		clicarPorTexto("Opção bem escondida");
	}

	public void acessarOpcaoEscondida() {
		clicarPorTexto("Opção bem escondida");
	}

	public void clicarDragDrop() {

		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		clicarPorTexto("Drag and drop");
	}

	public void acessarSBHibrido() {
		clicarPorTexto("SeuBarriga Híbrido");
	}
	
	public void acessarSBNativo() {
		clicarPorTexto("SeuBarriga Nativo");
	}

}
