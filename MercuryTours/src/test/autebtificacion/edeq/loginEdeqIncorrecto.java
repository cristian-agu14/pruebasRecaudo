package test.autebtificacion.edeq;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.LoginEdeq;
import pageObjects.LoginPage;
import pageObjects.MenuNavegacionPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;


public class loginEdeqIncorrecto extends TestBase{
	protected MenuNavegacionPage menuNavegacon;
	protected LoginPage login;
	
	//Utilidad para el manejo de excel
	static ExcelUtils excelDatosLogin;
	private String pageTitleIndex = "Welcome: Recaudos Edeq";
	private String userName="";
	private String password="";
	
	private LoginEdeq loginEdeq;
	
	/**
	 * Esta es una prueba que intentara loguearse con datos erroneos 
	 */
	@Test
	public void loginIncorrecto(){
		try{
			//Se crea la instancia para manejar el archivo DatosLogin.xlsx
			excelDatosLogin= new ExcelUtils("DatosLogin.xlsx",ExcelType.XLSX);
			userName=excelDatosLogin.getCellData(2, 1);
			password=excelDatosLogin.getCellData(2, 2);
			System.out.println(userName + "-" + password);
			login=new LoginPage(driver, pageTitleIndex);
			login.loginMercuryTours(userName, password);  
			
			//Assert.assertEquals(driver.getTitle(), "Sign-on: Recaudos Edeq");
			loginEdeq = new LoginEdeq(driver, "Edeq");
			System.out.println(loginEdeq.getBtnCerrarSesion());
			Assert.assertFalse(login.isElementPresentAndDisplay(loginEdeq.getBtnCerrarSesion()));
			//Assert.a
		}catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

}
