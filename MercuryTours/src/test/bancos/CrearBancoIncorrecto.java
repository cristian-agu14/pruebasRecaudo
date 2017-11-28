package test.bancos;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.BancosCrear;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class CrearBancoIncorrecto extends TestBase{
	
	

	protected BancosCrear bancosCrear;
	//protected
	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils exelDatosBancos;
	private String nombreBanco="";
	//private String msjConfirmacion="";
	
	/**
	 * Metodo que prueba que no se ingresen bancos repetidos 
	 */
	@Test
	public void crearBancoRepetido() {
		int bancoExcel=1;//indice de las colomnas con los nombres en excel
		try {
			
			exelDatosBancos= new ExcelUtils("datosBancos.xlsx",ExcelType.XLSX);
			nombreBanco = exelDatosBancos.getCellData(1, bancoExcel);
			System.out.println(nombreBanco);
			
			
			bancosCrear= new BancosCrear(driver, pageFindFlight);
			//bancosCrear.crearBancos(nombreBanco);
			//bancosCrear.crearBancos("nombreBanco");
			//System.out.println(bancosCrear.getMsjValidacion());
			
			Assert.assertEquals("Este banco ya se encuentra en uso", bancosCrear.crearBancosRepetido(nombreBanco));
		
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que prueba que no se inserten bancos con numeros o caracteres especiales
	 * la prueba pasa cuando lee el menjase de informacion cunado se le da click al boton Crear
	 */
	@Test
	public void crearBancoConNumeros() {
		try {
		exelDatosBancos= new ExcelUtils("datosBancos.xlsx",ExcelType.XLSX);
		nombreBanco = exelDatosBancos.getCellData(2, 1);
		System.out.println(nombreBanco);
		
		bancosCrear= new BancosCrear(driver, pageFindFlight);
		//bancosCrear.crearBancos(nombreBanco);
		//System.out.println(bancosCrear.getMsjValidacion());
		
		Assert.assertEquals("Solo se permiten letras", bancosCrear.crearBancosConNumeros(nombreBanco));
		
		}catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
}
