package modelo;

public class Literal implements Indicador {

	private double valor;

	public Literal(double valor) {
		this.valor = valor;
	}

	@Override
	public double valor(Integer periodo) {
		return this.valor;
	}

}
