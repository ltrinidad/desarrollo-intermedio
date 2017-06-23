package modelo;

public class Division extends OperacionBinaria {
	
	public Division(Formula izquierdo, Formula derecho) {
		super('/', izquierdo, derecho);
	}

	@Override
	public double valor(Integer periodo) {
		return this.izquierdo.valor(periodo) / this.derecho.valor(periodo);
	}
	
}
