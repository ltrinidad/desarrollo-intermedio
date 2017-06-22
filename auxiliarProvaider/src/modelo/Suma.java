package modelo;

public class Suma implements Indicador {
	private Indicador izquierdo;
	private Indicador derecho;

	public Suma(Indicador izquierdo, Indicador derecho) {
		this.izquierdo = izquierdo;
		this.derecho = derecho;
	}

	@Override
	public double valor(Integer periodo) {
		return this.izquierdo.valor(periodo) + this.derecho.valor(periodo);
	}

}
