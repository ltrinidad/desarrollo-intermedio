package modelo;

public abstract class OperacionBinaria implements Formula {
	private char operacion;
	protected Formula izquierdo;
	protected Formula derecho;
	
	public OperacionBinaria(char operacion, Formula izquierdo, Formula derecho) {
		this.operacion = operacion;
		this.izquierdo = izquierdo;
		this.derecho = derecho;
	}

	@Override
	public abstract double valor(Integer periodo);

	@Override
	public String formula() {
		return this.izquierdo.formula() + this.operacion + this.derecho.formula();
	}

}
