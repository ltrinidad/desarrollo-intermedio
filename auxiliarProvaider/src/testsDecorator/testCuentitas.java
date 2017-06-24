package testsDecorator;

import org.junit.Assert;
import org.junit.Test;

import fixtures.FixtureCuentas;
import model.ResumenDeCuentas;
import modelo.CuentaDecorator;
import modelo.FormulaDelIndicador;
import modelo.Literal;
import modelo.Producto;
import modelo.Suma;

public class testCuentitas {
	private static double DELTA = 1e-15;
	ResumenDeCuentas resumenMock = FixtureCuentas.resumenFB();
	
	@Test
	public void laFormula2Mas3Da5() {
		FormulaDelIndicador formulaDelIndicador = new Suma(new Literal(2.0), new Literal(3.0));
		
		Assert.assertEquals(5.0, formulaDelIndicador.valor(null), DELTA);
	}

	@Test
	public void laFormulaConstante2Da2() {
		FormulaDelIndicador formulaDelIndicador = new Literal(2.0);
		
		Assert.assertEquals(2.0, formulaDelIndicador.valor(null), DELTA);
	}
	
	@Test
	public void laFormula2PorEbitdaPara2017Da24000() {
		FormulaDelIndicador formulaDelIndicador = new Producto(new Literal(2.0), new CuentaDecorator(this.resumenMock, "EBITDA"));
		
		Assert.assertEquals(24000.0, formulaDelIndicador.valor(2017), DELTA);
	}

}
