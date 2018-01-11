package test.Pagos;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.PagoObligaciones;
import test.autebtificacion.edeq.LoginCajero;

public class RealizarPagos extends TestBase {

	private LoginCajero loginCajero = new LoginCajero();
	private String pageFindFlight = "Find a Flight: Edeq";
	private PagoObligaciones pago;

	@Test
	public void realizarPagoEfectivo() {
		loginCajero.loginCorrecto();
		pago = new PagoObligaciones(driver, pageFindFlight);
		try {
			Assert.assertTrue(pago.pagarSoloEfectivo());

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
