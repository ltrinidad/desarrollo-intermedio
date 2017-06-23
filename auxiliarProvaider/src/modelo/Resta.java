package modelo;

public class Resta extends OperacionBinaria {
	
	public Resta(Formula izquierdo, Formula derecho) {
		super('-', izquierdo, derecho);
	}

	@Override
	public double valor(Integer periodo) {
		return this.izquierdo.valor(periodo) - this.derecho.valor(periodo);
	}

}
