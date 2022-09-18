/*
 * Nome: Maria Luciana Almeida Pereira
 * Matrícula: 20211103020010
 * */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Imobiliaria {
	private String dataAtual;
	private double valorAluguel;
	
	public Imobiliaria(String dataAtual, double valorAluguel) {
		this.dataAtual = dataAtual;
		this.valorAluguel = valorAluguel;
	}
	
	public double receberPagamentoAluguel(double valorAluguel, String dataPagamento) {
		SimpleDateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
		Date dataP, dataAtual;
		double valorTotal = 0;
		try {
			dataP = formato.parse(dataPagamento);
			dataAtual = formato.parse(this.dataAtual);
			this.valorAluguel = valorAluguel;
			
			Calendar calPagamento = Calendar.getInstance();
			Calendar calAtual = Calendar.getInstance();
			
			calPagamento.setTime(dataP);
			calAtual.setTime(dataAtual);
			
			double dia = calPagamento.get(Calendar.DAY_OF_MONTH);
			double mesPagamento = calPagamento.get(Calendar.MONTH) + 1;
			double mesAtual = calAtual.get(Calendar.MONTH) + 1;
			
			if(mesPagamento >= 1 && mesPagamento <= 12) {
				if(mesPagamento == mesAtual) {
					if(dia >= 1 && dia <= 5) {
						valorTotal = calcularDesconto(10);
					} else if (dia >= 6 && dia <= 10) {
						valorTotal = calcularDesconto(5);
					} else if (dia >= 11 && dia <= 15) {
						valorTotal = valorAluguel;
					} else if (dia > 15) {
						valorTotal = calcularMulta(2);
					} 
				} else if (dataAtual.before(dataP)) {
					double qtdMesesEmAtraso = mesPagamento - mesAtual;
					valorTotal = calcularJuros(qtdMesesEmAtraso);
				} 
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return valorTotal;
	}

	public double calcularDesconto(double desconto) {
		return this.valorAluguel -= this.valorAluguel * desconto/100;
	}
	
	public double calcularMulta(double multa) {
		return this.valorAluguel += this.valorAluguel * multa/100;
	}
	
	public double calcularJuros(double atraso) {
		this.valorAluguel += this.valorAluguel * 2/100;
		return this.valorAluguel += this.valorAluguel * atraso/100;
	}
}