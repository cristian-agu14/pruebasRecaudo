package test.cajas;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.EscribeFichero;
import base.LeeFichero;
import base.TestBase;
import objectsEdeq.Caja;
import test.autebtificacion.edeq.LoginEdeqCorrecto;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class CrearCaja extends TestBase {

	private EscribeFichero escribeFichero;
	private LeeFichero leer;
	private LoginEdeqCorrecto login = new LoginEdeqCorrecto();

	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils excelDatosCaja;

	private String numeroCaja = "";

	private String municipio = "";

	/*
	 * El idExcelMunicipio va desde 2 que es armenia, hasta 13 que es salento
	 */
	int idExcelMunicipio = 1;
	String ultimaCajaIngresada = "";

	/**
	 * Method that test the create of varias cajas, este metodo crea 16 cajas en
	 * cada municipio, lo que cambia es el indice del municipio, si el municipio no
	 * es Armenia se usa un fechero en el escritorio con el number de la caja
	 */
	@Test
	private void crearCaja() {
		Caja caja = new Caja(driver, pageFindFlight);
		login.loginCorrecto();
		escribeFichero = new EscribeFichero();
		leer = new LeeFichero();
		int aux = 0;
		try {
			excelDatosCaja = new ExcelUtils("datosCajas.xlsx", ExcelType.XLSX);
			for (int i = 1; i < 16; i++) {
				municipio = excelDatosCaja.getCellData(idExcelMunicipio, i);
				if (municipio.equals("Armenia")) {
					numeroCaja = excelDatosCaja.getCellData(1, i);
					escribeFichero.guardar(numeroCaja);
					caja.crearCaja(numeroCaja, municipio, "");
				} else {
					numeroCaja = leer.leer();
					aux = Integer.parseInt(numeroCaja);
					aux = aux + 1;
					caja.crearCaja(numeroCaja, municipio, "");
					escribeFichero.guardar(aux + "");

				}
				// ultimaCajaIngresada = numeroCaja;

			}

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

}
