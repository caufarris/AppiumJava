package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.DragDropPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class DragDropTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private DragDropPage dragdrop = new DragDropPage();

	private String[] estadoInicial = new String[] { "Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"e arraste para", "qualquer local desejado." };
	private String[] estadoIntermediario = new String[] { "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"e arraste para", "Esta", "qualquer local desejado." };
	private String[] estadoFinal = new String[] { "Faça um clique longo,", "é uma lista", "Drag em Drop!",
			"e arraste para", "Esta", "qualquer local desejado." };

	@Test
	public void realizarDragDrop() {
		// Acessar menu
		menu.clicarDragDrop();

		// Veriicar estado inicial
		aguardar(1000);
		Assert.assertArrayEquals(estadoInicial, dragdrop.obterLista());

		// Arrastar "Esta" para "e arraste para"
		dragdrop.arrastar("Esta", "e arraste para");

		// Verificar estado intermediário
		aguardar(1000);
		Assert.assertArrayEquals(estadoIntermediario, dragdrop.obterLista());

		// Arrastar "Faça um clique longo," para "é uma lista"
		dragdrop.arrastar("Faça um clique longo", "é uma lista");

		// Verificar estado final
		aguardar(1000);
		Assert.assertArrayEquals(estadoFinal, dragdrop.obterLista());

	}

}
