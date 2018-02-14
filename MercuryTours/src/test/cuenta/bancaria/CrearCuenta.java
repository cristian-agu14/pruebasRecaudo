package test.cuenta.bancaria;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.CuentasBancarias;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class CrearCuenta extends TestBase {

	protected CuentasBancarias cuentasBancarias;

	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils exelDatosCuentas;
	private String nombreCuenta = "";
	private String numeroCuenta = "";
	private String cuentaContable = "";
	private String tipoCuenta = "";
	private String banco = "";
	int indiceCuenta=3;

	/**
	 * Method that test the action of created bank account
	 */
	@Test
	private void crearCuenta() {
		try {
			cuentasBancarias = new CuentasBancarias(driver, pageFindFlight);
			exelDatosCuentas = new ExcelUtils("CuentasBancarias.xlsx", ExcelType.XLSX);

			nombreCuenta = exelDatosCuentas.getCellData(1, indiceCuenta);
			banco = exelDatosCuentas.getCellData(2, indiceCuenta);
			tipoCuenta = exelDatosCuentas.getCellData(3, indiceCuenta);
			numeroCuenta = exelDatosCuentas.getCellData(4, indiceCuenta);
			cuentaContable = exelDatosCuentas.getCellData(5, indiceCuenta);

			Assert.assertTrue(cuentasBancarias.crearCuenta(nombreCuenta, numeroCuenta, seleccionarCuenta(tipoCuenta),
					banco, cuentaContable));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * Method that selects the type of account
	 * 
	 * @param tipoCuenta2
	 *            name of type of the account 
	 * @return true if is one account current
	 * @return false if is  one account of savings
	 */
	private boolean seleccionarCuenta(String tipoCuenta2) {
		if (tipoCuenta2.equals("cte")) {
			return true;
		} else {
			return false;
		}
	}

}
