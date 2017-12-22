package test.bancos;

import java.util.ArrayList;

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
	private ArrayList<ExcelUtils> hoal = new ArrayList<>();

	@Test
	public void crearBanco() {
		int bancoExcel = 1;// indice de las colomnas con los nombres en excel
		try {

			exelDatosBancos = new ExcelUtils("datosBancos.xlsx", ExcelType.XLSX);
			nombreBanco = exelDatosBancos.getCellData(1, bancoExcel);
			codigo = exelDatosBancos.getCellData(2, bancoExcel);
			System.out.println(nombreBanco);

			bancosCrear = new BancosCrear(driver, pageFindFlight);

			System.out.println(bancosCrear.getMsjValidacion());

			Assert.assertTrue(bancosCrear.crearBancos(nombreBanco, codigo));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}	
	}

}
