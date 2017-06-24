package modelo;

public class Indicador extends Coeficiente {
	private FormulaDelIndicador formula;
	
	public Indicador(String nombre, FormulaDelIndicador formula) {
		super(nombre);
		this.formula = formula;
	}
	
	public double valor(Integer periodo) {
		return this.formula.valor(periodo);
	}
	
	public String formulaCompleta(){
		return this.nombre + '=' + this.formula.formula();
	}
	
}
