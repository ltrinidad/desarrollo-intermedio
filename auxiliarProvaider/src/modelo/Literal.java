package modelo;

public class Literal implements Formula {
	private Double valor;

	public Literal(Double valor) {
		this.valor = valor;
	}

	@Override
	public double valor(Integer periodo) {
		return this.valor;
	}

	@Override
	public String formula() {
		return valor.toString();
	}
	
}
