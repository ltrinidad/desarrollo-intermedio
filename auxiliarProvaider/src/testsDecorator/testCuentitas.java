package testsDecorator;

import org.junit.Assert;
import org.junit.Test;

import fixtures.FixtureCuentas;
import model.ResumenDeCuentas;
import modelo.CuentaDecorator;
import modelo.Formula;
import modelo.Literal;
import modelo.Producto;
import modelo.Suma;

public class testCuentitas {
	private static double DELTA = 1e-15;
	ResumenDeCuentas resumenMock = FixtureCuentas.resumenFB();
	
	@Test
	public void laFormula2Mas3Da5() {
		Formula formula = new Suma(new Literal(2.0), new Literal(3.0));
		
		Assert.assertEquals(5.0, formula.valor(null), DELTA);
	}

	@Test
	public void laFormulaConstante2Da2() {
		Formula formula = new Literal(2.0);
		
		Assert.assertEquals(2.0, formula.valor(null), DELTA);
	}
	
	@Test
	public void laFormula2PorEbitdaPara2017Da24000() {
		Formula formula = new Producto(new Literal(2.0), new CuentaDecorator(this.resumenMock, "EBITDA"));
		
		Assert.assertEquals(24000.0, formula.valor(2017), DELTA);
	}

}
