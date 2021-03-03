package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import br.ce.wcaquino.appium.core.DriverFactory;

public class FormularioPage extends BasePage {

	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);

	}

	public String verificarNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}

	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);

	}

	public String verificarOpcaoCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheckbox() {
		clicar(By.className("android.widget.CheckBox"));
	}

	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}

	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}

	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	}

	public void clicarSeekBar(double posicao) {
		int delta = 50;
		MobileElement seek = DriverFactory.getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println(y);
		
		int xinicial = seek.getLocation().x + delta;
		int x = (int) (xinicial + ((seek.getSize().width - 2*delta) * posicao));
		System.out.println(x);

		tap(x, y);

	}

	public void salvar() {
		clicarPorTexto("SALVAR");
	}

	public String verificarNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}

	public String verificarJogoCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}

	public String verificarSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}

	public String verificarCheckboxCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}

}