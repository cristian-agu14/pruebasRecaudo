package test.bancos;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.BancosCrear;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class CrearBancoCorrecto extends TestBase{

	protected BancosCrear bancosCrear;
	//protected
	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils exelDatosBancos;
	private String nombreBanco="";
	//private String msjConfirmacion="";
	
	@Test
	public void crearBanco() {
		int bancoExcel=3;//indice de las colomnas con los nombres en excel
		try {
			
			exelDatosBancos= new ExcelUtils("datosBancos.xlsx",ExcelType.XLSX);
			nombreBanco = exelDatosBancos.getCellData(1, bancoExcel);
			System.out.println(nombreBanco);
			
			bancosCrear= new BancosCrear(driver, pageFindFlight);
			bancosCrear.crearBancos(nombreBanco);
			//bancosCrear.crearBancos("nombreBanco");
			System.out.println(bancosCrear.getMsjValidacion());
			//Assert.assertEquals(bancosCrear.getMsjValidacion(),"[El banco fue agregado exitosamente] but found [Proxy element for: DefaultElementLocator 'By.className: toast-message'");
			
			Assert.assertEquals(nombreBanco, bancosCrear.getCajatextobuscador());
		
		
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void editar() {
//		
//	}
		

}
