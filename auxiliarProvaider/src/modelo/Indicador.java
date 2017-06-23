package modelo;

public class Indicador {
	public String nombre;
	private Formula formula;
	
	public Indicador(String nombre, Formula formula) {
		this.nombre = nombre;
		this.formula = formula;
	}
	
	public double valor(Integer periodo) {
		return this.formula.valor(periodo);
	}
	
	public String formula() {
		return this.formula.formula();
	}
	
}
