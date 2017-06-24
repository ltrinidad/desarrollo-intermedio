package modelo;

import model.ResumenDeCuentas;

public class CuentaDecorator extends Coeficiente {
	private ResumenDeCuentas resumen;
	private String nombre; 
	
	public CuentaDecorator(ResumenDeCuentas resumen, String nombre) {
		super(nombre);
		this.resumen = resumen;
	}

	@Override
	public double valor(Integer periodo) {		
		return this.resumen.calcularElValorDeLaCuenta(this.nombre, periodo);
	}
	
}