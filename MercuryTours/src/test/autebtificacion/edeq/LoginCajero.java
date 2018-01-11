package test.autebtificacion.edeq;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.FindFlightPage;
import pageObjects.LoginPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class LoginCajero extends TestBase{

	protected LoginPage login;
	protected FindFlightPage findFlight;
	static ExcelUtils excelDatosLogin;
	private String pageTitleIndex = "Recaudos edeq";
	private String pageFindFlight = "Find a Flight:";
	private String userName = "";
	private String password = "";

	@Test
	public void loginCorrecto() {
		try {
			// Se crea la instancia para manejar el archivo DatosLogin.xlsx
			excelDatosLogin = new ExcelUtils("datosloginEdeq.xlsx", ExcelType.XLSX);
			userName = excelDatosLogin.getCellData(3, 1);
			password = excelDatosLogin.getCellData(3, 2);
			System.out.println(userName + "-" + password);

			login = new LoginPage(driver, pageTitleIndex);
			login.loginMercuryTours(userName, password);
			findFlight = new FindFlightPage(driver, pageFindFlight);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
