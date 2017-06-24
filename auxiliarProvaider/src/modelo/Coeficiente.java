package modelo;

public abstract class Coeficiente implements FormulaDelIndicador {
	protected String nombre;

	protected Coeficiente(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public abstract double valor(Integer periodo);

	@Override
	public String formula() {
		return this.nombre;
	}

}
