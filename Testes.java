/*
 * Nome: Maria Luciana Almeida Pereira
 * Matrícula: 20211103020010
 * */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testes {
	
	@Test
	void testarPagamentoAntesDoDia5() {
		double valorDoAluguel = 100.0;
		String dataPagamento = "04/09/2022";
		String dataAtual = "16/09/2022";
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.receberPagamentoAluguel(valorDoAluguel, dataPagamento);
		
		assertEquals(90.0, resultado);
	}
	
	@Test
	void testarPagamentoNoDia5() {
		double valorDoAluguel = 100.0;
		String dataPagamento = "05/09/2022";
		String dataAtual = "16/09/2022";
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.receberPagamentoAluguel(valorDoAluguel, dataPagamento);
		
		assertEquals(90.0, resultado);
	}
	
	@Test
	void testarPagamentoAntesDoDia10() {
		double valorDoAluguel = 100.0;
		String dataPagamento = "06/09/2022";
		String dataAtual = "16/09/2022";
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.receberPagamentoAluguel(valorDoAluguel, dataPagamento);
		
		assertEquals(95.0, resultado);
	}
	
	@Test
	void testarPagamentoNoDia10() {
		double valorDoAluguel = 100.0;
		String dataPagamento = "10/09/2022";
		String dataAtual = "16/09/2022";
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.receberPagamentoAluguel(valorDoAluguel, dataPagamento);
		
		assertEquals(95.0, resultado);
	}
	
	@Test
	void testarPagamentoAntesDoDia15() {
		double valorDoAluguel = 100.0;
		String dataPagamento = "11/09/2022";
		String dataAtual = "16/09/2022";
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.receberPagamentoAluguel(valorDoAluguel, dataPagamento);
		
		assertEquals(100.0, resultado);
	}
	
	@Test
	void testarPagamentoNoDia15() {
		double valorDoAluguel = 100.0;
		String dataPagamento = "15/09/2022";
		String dataAtual = "16/09/2022";
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.receberPagamentoAluguel(valorDoAluguel, dataPagamento);
		
		assertEquals(100.0, resultado);
	}
	
	@Test
	void testarPagamentoDepoisDoDia15() {
		double valorDoAluguel = 100.0;
		String dataPagamento = "16/09/2022";
		String dataAtual = "16/09/2022";
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.receberPagamentoAluguel(valorDoAluguel, dataPagamento);
		
		assertEquals(102.0, resultado);
	}
	
	@Test
	void testarPagamentoDepoisDoDia15DeOutroMes() {
		double valorDoAluguel = 100.0;
		String dataPagamento = "16/10/2022";
		String dataAtual = "16/09/2022";
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.receberPagamentoAluguel(valorDoAluguel, dataPagamento);
		
		assertEquals(103.02, resultado);
	}
	
	@Test
	void testarCalculo10PorcentoDeDesconto() {
		double valorDoAluguel = 100.0;
		String dataAtual = "16/09/2022";
		double desconto = 10;
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.calcularDesconto(desconto);
		
		assertEquals(90.0, resultado);
	}
	
	@Test
	void testarCalculo5PorcentoDeDesconto() {
		double valorDoAluguel = 100.0;
		String dataAtual = "16/09/2022";
		double desconto = 5;
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.calcularDesconto(desconto);
		
		assertEquals(95.0, resultado);
	}
	
	@Test
	void testarCalculoMulta() {
		double valorDoAluguel = 100.0;
		String dataAtual = "16/09/2022";
		double multa = 2;
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.calcularMulta(multa);
		
		assertEquals(102.0, resultado);
	}
	
	@Test
	void testarCalculoJurosDeUmMesDeAtraso() {
		double valorDoAluguel = 100.0;
		String dataAtual = "16/09/2022";
		double atraso = 1;
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.calcularJuros(atraso);
		
		assertEquals(103.02, resultado);
	}
	
	@Test
	void testarCalculoJurosDeDoisMesesDeAtraso() {
		double valorDoAluguel = 100.0;
		String dataAtual = "16/09/2022";
		double atraso = 2;
		Imobiliaria imobiliaria = new Imobiliaria(dataAtual, valorDoAluguel);
		
		double resultado = imobiliaria.calcularJuros(atraso);
		
		assertEquals(104.04, resultado);
	}
}
