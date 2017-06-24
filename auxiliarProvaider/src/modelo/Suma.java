package modelo;

public class Suma extends OperacionBinaria {
	
	public Suma(FormulaDelIndicador izquierdo, FormulaDelIndicador derecho) {
		super('+', izquierdo, derecho);
	}

	@Override
	public double valor(Integer periodo) {
		return this.izquierdo.valor(periodo) + this.derecho.valor(periodo);
	}

}

