package test.cupones;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.Cupones;
import test.Pagos.RealizarPagos;
import test.autebtificacion.edeq.LoginCajero;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class Cupon extends TestBase {
	
	private String nitEmpresa;

	private String nombreEmpresa;

	private String numeroReferencia;

	private String valorSAC;

	private String codigoBarras;

	private String valorCupon;

	static ExcelUtils excelDatosCupones;

	private LoginCajero loginCajero;

	private String pageFindFlight = "Find a Flight: Edeq";

	private Cupones cupones;
	
	private RealizarPagos realizarPagos;

	@Test
	private void crearCupon() {
		int indiceCupones = 1;
		loginCajero = new LoginCajero();
		loginCajero.loginCorrecto();
		cupones = new Cupones(driver, pageFindFlight);
		realizarPagos = new RealizarPagos();
		try {
			excelDatosCupones = new ExcelUtils("cupones.xlsx", ExcelType.XLSX);
			nombreEmpresa = excelDatosCupones.getCellData(2, indiceCupones);
			nitEmpresa = excelDatosCupones.getCellData(1, indiceCupones);
			numeroReferencia = excelDatosCupones.getCellData(3, indiceCupones);
			valorSAC = excelDatosCupones.getCellData(4, indiceCupones);
			codigoBarras = excelDatosCupones.getCellData(5, indiceCupones);
			//valorCupon = excelDatosCupones.getCellData(6, indiceCupones);
			cupones.crearCupon(nitEmpresa, nombreEmpresa, numeroReferencia, valorSAC, codigoBarras, valorCupon);
			realizarPagos.realizarPagoEfectivo(valorCupon);
			
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
