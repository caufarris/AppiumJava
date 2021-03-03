package br.ce.wcaquino.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.FormularioPage;
import br.ce.wcaquino.appium.page.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest {


	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}

	@Test
	public void preencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Claudia");

		// Checar nome
		Assert.assertEquals("Claudia", page.verificarNome());
	}

	@Test
	public void interagirCombo() throws MalformedURLException {

		// Clicar no combo
		page.selecionarCombo("PS4");

		// Verificar opção selecionada
		Assert.assertEquals("PS4", page.verificarOpcaoCombo());
	}

	@Test
	public void interagirSwitchCheckbox() throws MalformedURLException {

		// Verificar status dos elementos
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		// Clicar nos elementos
		page.clicarCheckbox();
		page.clicarSwitch();

		// Verificar estados alterados

		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());

	}

	@Test
	public void realizarCadastro() throws MalformedURLException {

		// Preencher campos
		page.escreverNome("Claudia");
		page.clicarCheckbox();
		page.clicarSwitch();
		page.selecionarCombo("PS4");

		// Salvar
		page.salvar();

		// Verificações

		Assert.assertEquals("Nome: Claudia", page.verificarNomeCadastrado());
		Assert.assertEquals("Console: ps4", page.verificarJogoCadastrado());
		Assert.assertTrue(page.verificarCheckboxCadastrado().endsWith("Marcado"));
		Assert.assertTrue(page.verificarSwitchCadastrado().endsWith("Off"));

	}
	
	@Test
	public void alterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
	}
	
	@Test
	public void alterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("10:40"));
	}
	
	@Test
		public void interagirComSeekBar() {
		page.clicarSeekBar(0.67);
		page.salvar();
	}
	
	

}
