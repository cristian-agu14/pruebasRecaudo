package test.proveedor;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.ProveedoresRecaudo;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class Proveedor extends TestBase {

	static ExcelUtils excelDatosProvedor;

	private ProveedoresRecaudo proveedoresRecaudo;
	private String pageFindFlight = "Find a Flight: Edeq";

	private String numeroEmpresa = "";
	private String nombreEmpresa = "";
	private String telefono = "";
	private String direccion = "";
	private String numeroSAC = "";
	private String formatoRecaudo = "";

	@Test
	public void crearClienteRecauco() {
		int indice = 1;
		proveedoresRecaudo = new ProveedoresRecaudo(driver, pageFindFlight);
		try {

			excelDatosProvedor = new ExcelUtils("proveedores.xlsx", ExcelType.XLSX);
			numeroEmpresa = excelDatosProvedor.getCellData(1, indice);
			nombreEmpresa = excelDatosProvedor.getCellData(2, indice);
			telefono = excelDatosProvedor.getCellData(3, indice);
			direccion = excelDatosProvedor.getCellData(4, indice);
			numeroSAC = excelDatosProvedor.getCellData(5, indice);
			formatoRecaudo = excelDatosProvedor.getCellData(6, indice);
			
			Assert.assertTrue(proveedoresRecaudo.crearProveedor(numeroEmpresa, nombreEmpresa, telefono, direccion, numeroSAC,
					formatoRecaudo));

		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}

	}
}
