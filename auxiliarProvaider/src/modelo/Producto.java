package modelo;

public class Producto extends OperacionBinaria {
	
	public Producto(Formula izquierdo, Formula derecho) {
		super('*', izquierdo, derecho);		
	}
	
	@Override
	public double valor(Integer periodo) {
		return this.izquierdo.valor(periodo) * this.derecho.valor(periodo);
	}
	
}
