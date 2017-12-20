package proveedores.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.PageBase;
import base.TestBase;
import objectsEdeq.CuentasBancarias;
import objectsEdeq.ProveedoresCrear;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class CrearProveedor extends TestBase {

	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils exelDatosProveedores;
	private String numeroEmpresa = "";
	private String nombreEmpresa = "";
	private String telefono = "";
	private String direccion = "";
	private String cajaSAC = "";
	private String formatoRecaudo = "";
	int indiceCuenta = 1;


	/**
	 * Metodo que prueba la creacion de los proveedores de recaudos
	 */
	@Test
	public void crearProvvedor() {
		ProveedoresCrear proveedoresCrear = new ProveedoresCrear(driver, pageFindFlight);
		try {
			exelDatosProveedores = new ExcelUtils("proveedores.xlsx", ExcelType.XLSX);

			numeroEmpresa = exelDatosProveedores.getCellData(1, indiceCuenta);
			nombreEmpresa = exelDatosProveedores.getCellData(2, indiceCuenta);
			telefono = exelDatosProveedores.getCellData(3, indiceCuenta);
			direccion = exelDatosProveedores.getCellData(4, indiceCuenta);
			cajaSAC = exelDatosProveedores.getCellData(5, indiceCuenta);
			formatoRecaudo = exelDatosProveedores.getCellData(6, indiceCuenta);

			Assert.assertTrue(proveedoresCrear.crearProveedor(numeroEmpresa, nombreEmpresa, telefono, direccion,
					cajaSAC, formatoRecaudo));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
