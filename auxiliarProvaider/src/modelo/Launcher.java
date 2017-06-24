package modelo;

import java.util.ArrayList;
import java.util.List;

import fixtures.FixtureCuentas;
import fixtures.FixtureIndicadores;
import model.Balance;
import model.Cuenta;
import modelo.Indicador;
import model.ResumenDeCuentas;
import parser.ParseException;
import parser.ParserInds;

public class Launcher {

	public static void main(String[] args) throws ParseException {
		String formula = "i=7";
		
		List<Balance> balancesEBITDA = new ArrayList<Balance>();
	    List<Balance> balancesFDS = new ArrayList<Balance>();
	    List<Cuenta> cuentas = new ArrayList<Cuenta>();
	 
	    balancesEBITDA.add( new Balance(2016, 10000) );
	    balancesEBITDA.add( new Balance(2017, 12000) );
	    balancesFDS.add( new Balance(2016, 14000) );
 
	    cuentas.add(new Cuenta("EBITDA", balancesEBITDA));
	    cuentas.add(new Cuenta("FDS", balancesFDS));
	    
	    ResumenDeCuentas resumen = new ResumenDeCuentas("facebook", cuentas);
		
		List<Indicador> indicadores = new ArrayList<Indicador>();
		 
	    Indicador indicador1 = new Indicador("indicador1", null);
	    Indicador indicador2 = new Indicador("indicador2", null);
	    Indicador indicador3 = new Indicador("indicador3", null);
	 	
	    indicadores.add(indicador1);
	    indicadores.add(indicador2);
	    indicadores.add(indicador3);
		
		Indicador ind = new ParserInds(new IndicadorBuilder(indicadores, resumen), formula).parsearFormula();
		
		System.out.println(ind.valor(2016));
		
	}

}
