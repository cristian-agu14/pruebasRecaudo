package test.buscador;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.BancosCrear;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class BuscardorBancos extends TestBase{
	
	protected BancosCrear bancosCrear;
	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils exelDatosBancos;
	private String nombreBanco="";
	
	
	@Test
	public void buscarBancoExistente() {
		try {
			exelDatosBancos= new ExcelUtils("datosBancos.xlsx",ExcelType.XLSX);
			nombreBanco = exelDatosBancos.getCellData(1, 8);
			System.out.println(nombreBanco);
			
			bancosCrear= new BancosCrear(driver, pageFindFlight);
			
			Assert.assertEquals("BANCO BBVA", bancosCrear.buscarBancoExitente(nombreBanco));
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	private void buscarBancoNoExistente() {
		try {
			exelDatosBancos= new ExcelUtils("datosBancos.xlsx",ExcelType.XLSX);
			nombreBanco = exelDatosBancos.getCellData(1, 9);
			System.out.println(nombreBanco);
			
			bancosCrear= new BancosCrear(driver, pageFindFlight);
			
			Assert.assertNotEquals("BANCO BBVA", bancosCrear.buscarBancoExitente(nombreBanco));
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
