package test.bancos;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.BancosCrear;
import test.autebtificacion.edeq.LoginEdeqCorrecto;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class CrearBancoCorrecto extends TestBase {

	protected BancosCrear bancosCrear;
	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils exelDatosBancos;
	private String nombreBanco = "";
	private String codigo = "";
	private LoginEdeqCorrecto login = new LoginEdeqCorrecto();
	// private ArrayList<ExcelUtils> hoal = new ArrayList<>();

	/**
	 * Metodo que prueba la creacion
	 */
	@Test
	public void crearBanco() {
		int bancoExcel = 2;// indice de las colomnas con los nombres en excel
		login.loginCorrecto();
		for (int i = 1; i < 16; i++) {

			try {

				exelDatosBancos = new ExcelUtils("datosBancos.xlsx", ExcelType.XLSX);
				nombreBanco = exelDatosBancos.getCellData(1, i);
				codigo = exelDatosBancos.getCellData(2, i);
				System.out.println(nombreBanco);

				bancosCrear = new BancosCrear(driver, pageFindFlight);

				System.out.println(bancosCrear.getMsjValidacion());
				
				bancosCrear.crearBancos(nombreBanco, codigo);

				//Assert.assertTrue(bancosCrear.crearBancos(nombreBanco, codigo));

			} catch (Exception e) {
				Assert.fail(e.getMessage());
				e.printStackTrace();
			}
		}
	}

}
