package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SeuBarriga.SBContasPage;
import br.ce.wcaquino.appium.page.SeuBarriga.SBHomePage;
import br.ce.wcaquino.appium.page.SeuBarriga.SBLoginPage;
import br.ce.wcaquino.appium.page.SeuBarriga.SBMenuPage;
import br.ce.wcaquino.appium.page.SeuBarriga.SBMovimentacaoPage;
import br.ce.wcaquino.appium.page.SeuBarriga.SBResumoPage;

public class SBNativoTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();

	@Before
	public void setUp() {
		menu.acessarSBNativo();
		login.setEmail("c@f");
		login.setSenha("cf");
		login.entrar();
	}

	@Test
	public void inserirContaComSucesso() {
		// Entrar contas
		menuSB.acessarContas();

		// Preencher Nome conta
		contas.setConta("Contas de Teste");

		// Salvar conta
		contas.salvar();

		// Verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}

	@Test
	public void excluirConta() {
		// Entrar contas
		menuSB.acessarContas();

		// Clique Longo em conta
		contas.selecionarConta("123");

		// Excluir conta
		contas.excluir();

		// Verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
	}

	@Test
	public void validarInclusaoMov() {
		//Acessar Movimentações
		menuSB.acessarMovimentacoes();

		// Validar descrição
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));

		//Validar Interessado
		mov.setDescricao("Desc");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));
		
		//Validar valor
		mov.setInteressado("inter");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));
		
		//Validar conta
		mov.setValor("123");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));
		
		//Inserir com sucesso
		mov.setConta("Contas de Teste");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
	}
	
	@Test
	public void atualizarSaldoAoExcluirMovimentacao() {
		//Verificar saldo "Conta para saldo" = 534.00
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
				
		//Ir para resumo
		menuSB.acessarResumo();
		
		//Excluir Movimentação 3
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		
		//Validar Mensagem "Movimentação removida com sucesso"
		Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));
		
		//Voltar Home
		menuSB.acessarHome();
		
		//Atualizar Saldos
		aguardar(1000);
		home.scroll(0.2, 0.9);
	
		//Verificar saldo = -1000.00
		Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
	}

}
