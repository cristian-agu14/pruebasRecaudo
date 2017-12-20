package test.cuenta.bancaria;

import static org.testng.Assert.assertEquals;

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
	int indiceCuenta=4;

	/**
	 * metodo que prueba la accion de crear cuentas bancarias
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

			// boolean aux =

			Assert.assertTrue(cuentasBancarias.crearCuenta(nombreCuenta, numeroCuenta, seleccionarCuenta(tipoCuenta),
					banco, cuentaContable));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que selecciona el tipo de cuenta
	 * 
	 * @param tipoCuenta2
	 *            nombre del tipo de la cuenta 
	 * @return true si es una cuenta corriente
	 * @return false si es una cuenta de ahorros
	 */
	private boolean seleccionarCuenta(String tipoCuenta2) {
		if (tipoCuenta2.equals("cte")) {
			return true;
		} else {
			return false;
		}
	}

}
