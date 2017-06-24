package modelo;

public abstract class OperacionBinaria implements FormulaDelIndicador {
	private char operacion;
	protected FormulaDelIndicador izquierdo;
	protected FormulaDelIndicador derecho;
	
	public OperacionBinaria(char operacion, FormulaDelIndicador izquierdo, FormulaDelIndicador derecho) {
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
