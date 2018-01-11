package test.sedes;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.Sedes;
import test.autebtificacion.edeq.LoginEdeqCorrecto;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class Sede extends TestBase {

	protected Sedes sedesCrear;

	private LoginEdeqCorrecto login = new LoginEdeqCorrecto();
	
	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils excelDatosSedes;
	String nombreSede = "";
	String direccionSede = "";
	String municipio = "";
	int indice = 1;

	/**
	 * metodo que prueba que se inserten los datos Exitosamente
	 */
	@Test
	public void crearSede() {
		login.loginCorrecto();
		try {
			sedesCrear = new Sedes(driver, pageFindFlight);
			excelDatosSedes = new ExcelUtils("Sedes.xlsx", ExcelType.XLSX);
			for (int i = 1; i < 13; i++) {

				nombreSede = excelDatosSedes.getCellData(1, i);
				direccionSede = excelDatosSedes.getCellData(2, i);
				municipio = excelDatosSedes.getCellData(3, i);

				sedesCrear.crearSede(nombreSede, direccionSede, municipio);
				// Assert.assertTrue(sedesCrear.CrearSede(nombreSede, direccionSede,
				// municipio));

			}
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
