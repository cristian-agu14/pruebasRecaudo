package test.sellos.humedos;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.SellosHumedos;
import utils.ExcelUtils;

public class SelloHumedo extends TestBase {

	protected SellosHumedos sellosHumedos;

	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils exelDatosBancos;
	String numeroSello="2";
	String cajero= "2";

	/**
	 * Metodo que prueba que se asignen correctamente los sellos humedos a un cajero
	 */
	@Test
	public void asignarSello() {
		try {
			
			sellosHumedos= new SellosHumedos(driver, pageFindFlight);
			Assert.assertTrue(sellosHumedos.crearSellohumedo(numeroSello, cajero));
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que prueba que no se ingresen sellos repetidos
	 */
	@Test
	private void asignarSelloRepetido() {
		try {
			
			sellosHumedos= new SellosHumedos(driver, pageFindFlight);
			sellosHumedos.ingresarAgregarSello(numeroSello, cajero);
			Assert.assertTrue(sellosHumedos.isElementPresentAndDisplay(sellosHumedos.getMsjErrorSelloHumedo()));
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
		
	

}
