package modelo;

import model.ResumenDeCuentas;

public class Cuenta implements Indicador {
	private ResumenDeCuentas resumen;
	private String nombre; 
	
	public Cuenta(ResumenDeCuentas resumen, String nombre) {
		this.resumen = resumen;
		this.nombre = nombre;
	}

	@Override
	public double valor(Integer periodo) {
		return this.resumen.calcularElValorDeLaCuenta(this.nombre, periodo);
	}

}
