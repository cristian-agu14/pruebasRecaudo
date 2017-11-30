package test.sedes;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.SedesCrear;
import objectsEdeq.SellosHumedos;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class Sede extends TestBase {

	protected SedesCrear sedesCrear;

	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils exelDatosSedes;
	String nombreSede = "";
	String direccionSede = "";
	String municipio = "";

	/**
	 * metodo que prueba que se inserten los datos Exitosamente
	 */
	@Test
	public void crearSede() {
		try {

			sedesCrear = new SedesCrear(driver, pageFindFlight);
			exelDatosSedes = new ExcelUtils("Sedes.xlsx", ExcelType.XLSX);
			nombreSede = exelDatosSedes.getCellData(1, 2);
			direccionSede = exelDatosSedes.getCellData(2, 2);
			municipio = exelDatosSedes.getCellData(3, 3);

			Assert.assertTrue(sedesCrear.CrearSede(nombreSede, direccionSede, municipio));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
