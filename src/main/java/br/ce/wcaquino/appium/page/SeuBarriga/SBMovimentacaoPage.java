package br.ce.wcaquino.appium.page.SeuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBMovimentacaoPage extends BasePage {

	public void salvar() {
		clicarPorTexto("SALVAR");
	}

	public void setDescricao(String desc) {
		escrever(By.className("android.widget.EditText"), desc);

	}

	public void setInteressado(String inter) {
		escrever(By.xpath("//android.widget.EditText[2]"), inter);
	}
	
	public void setValor(String valor) {
		escrever(By.xpath("//android.widget.EditText[3]"), valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
	}

}
