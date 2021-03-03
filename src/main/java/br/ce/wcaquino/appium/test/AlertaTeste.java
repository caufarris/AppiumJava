package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AlertaTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage alerta = new AlertaPage();
	private BasePage page = new BasePage();
	
	@Before
	public void setup() {
		menu.acessarAlertas();
	}
	
	
	@Test
	public void confirmarAlertas() {
		//Clicar em alert confirm
		alerta.clicarAlertaConfirm();
		
		//Verificar textos
		Assert.assertEquals("Info", alerta.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", alerta.obterMensagemAlerta());
		
		//Confirmar o alerta
		alerta.confirmarAlerta();
		
		//Verificar nova mensagem
		Assert.assertEquals("Confirmado", alerta.obterMensagemAlerta());
		
		//Sair
		alerta.sairAlerta();
		
	}
	
	@Test
	public void clicarForaAlerta() {
		//Clicar no alerta simples
		alerta.clicarAlertaSimples();
		
		//Clicar fora da caixa
		aguardar(1000);
		alerta.clicarForaCaixa();
		
		//Verificar que a mensagem não está presente
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}

}
