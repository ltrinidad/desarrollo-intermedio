package modelo;

import model.ResumenDeCuentas;

public class CuentaDecorator implements Formula {
	private ResumenDeCuentas resumen;
	private String nombre; 
	
	public CuentaDecorator(ResumenDeCuentas resumen, String nombre) {
		this.resumen = resumen;
		this.nombre = nombre;
	}

	@Override
	public double valor(Integer periodo) {
		return this.resumen.calcularElValorDeLaCuenta(this.nombre, periodo);
	}
	
	@Override
	public String formula() {
		return nombre;
	}

}