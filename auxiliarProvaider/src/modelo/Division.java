package modelo;

public class Division implements Indicador {

	private Indicador izquierdo;
	private Indicador derecho;

	public Division(Indicador izquierdo, Indicador derecho) {
		this.izquierdo = izquierdo;
		this.derecho = derecho;
	}

	@Override
	public double valor(Integer periodo) {
		return this.izquierdo.valor(periodo) / this.derecho.valor(periodo); 
	}

}
