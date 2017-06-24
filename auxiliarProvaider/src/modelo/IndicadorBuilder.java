package modelo;

import java.util.List;

import org.uqbar.commons.model.UserException;

import exceptions.CoeficientesInexistentesException;
import model.ResumenDeCuentas;
import parser.ParseException;
import parser.ParserInds;

public class IndicadorBuilder {
	private String nombreIndicador;
	private FormulaDelIndicador ladoIzquierdo;
	private FormulaDelIndicador ladoDerecho;
	private String operacion;
	private List<Indicador> indicadores;
	private ResumenDeCuentas resumen;

	public IndicadorBuilder(List<Indicador> indicadores, ResumenDeCuentas resumen) {
		this.indicadores = indicadores;
		this.resumen = resumen;
	}
	
	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}
	
	private boolean esUnIndicador(String nombre) {
		return this.indicadores.stream().anyMatch( unIndicador -> unIndicador.nombre.equals(nombre) );
	}
	
	public void setLadoIzquierdo(FormulaDelIndicador ladoIzquierdo) {
		this.ladoIzquierdo = ladoIzquierdo;
	}
	
	public void setLadoDerecho(FormulaDelIndicador ladoDerecho) {
		this.ladoDerecho = ladoDerecho;
	}
	
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	public void crearCoefIzquierdo(String nombre) {
		this.setLadoIzquierdo(this.crearSegunTipo(nombre));
	}
	
	public void crearCoefDerecho(String nombre) {
		this.setLadoDerecho(this.crearSegunTipo(nombre));
	}
	
	private FormulaDelIndicador crearSegunTipo(String nombre) {
		if( this.resumen.tieneCuentaDeNombre(nombre) )
			return new CuentaDecorator(this.resumen, nombre);
		if( this.esUnIndicador(nombre) ) {
			Indicador ind = this.indicadores.stream()
											.filter(unInd -> unInd.nombre.equals(nombre))
											.findFirst()
											.get();
			
			try {
				return new ParserInds(new IndicadorBuilder(this.indicadores, this.resumen), ind.formulaCompleta()).parsearFormula();
			} catch (ParseException e) {
				throw new UserException("FALTA RESOLVER FALTA RESOLVER!!!");
			}
		}
		throw new CoeficientesInexistentesException("La formula posee un indicador o una cuenta invalida");
	}
	
	public Indicador construir() {
		switch (this.operacion) {
			case "+":
			  return new Indicador(this.nombreIndicador, new Suma(this.ladoIzquierdo, this.ladoDerecho));
			case "-":
			  return new Indicador(this.nombreIndicador, new Resta(this.ladoIzquierdo, this.ladoDerecho));
			case "*":
			  return new Indicador(this.nombreIndicador, new Producto(this.ladoIzquierdo, this.ladoDerecho));
			case "/":
			  return new Indicador(this.nombreIndicador, new Division(this.ladoIzquierdo, this.ladoDerecho));
			default:
			  return new Indicador(this.nombreIndicador, this.ladoIzquierdo);
		}
	}
	
}