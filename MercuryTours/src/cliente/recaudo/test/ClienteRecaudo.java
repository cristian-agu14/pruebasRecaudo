package cliente.recaudo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.ClienteRecaudoss;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class ClienteRecaudo extends TestBase {

	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils excelDatosclientesRecaudos;
	private String numeroCliente = "";
	private String nombreCliente = "";
	private String telefono = "";
	private String contacto = "";
	private String correo = "";
	private String celular = "";
	private String direccion = "";

	int indiceCuenta = 4;

	/**
	 * Metodo que prueba la creacion de los proveedores de recaudos
	 */
	@Test
	public void crearClienteRecaudo() {
		ClienteRecaudoss clienteRecaudo = new ClienteRecaudoss(driver, pageFindFlight);
		try {
			excelDatosclientesRecaudos = new ExcelUtils("clientesRecaudos.xlsx", ExcelType.XLSX);

			numeroCliente = excelDatosclientesRecaudos.getCellData(1, indiceCuenta);
			nombreCliente = excelDatosclientesRecaudos.getCellData(2, indiceCuenta);
			telefono = excelDatosclientesRecaudos.getCellData(3, indiceCuenta);
			contacto = excelDatosclientesRecaudos.getCellData(4, indiceCuenta);
			correo = excelDatosclientesRecaudos.getCellData(5, indiceCuenta);
			celular = excelDatosclientesRecaudos.getCellData(6, indiceCuenta);
			direccion = excelDatosclientesRecaudos.getCellData(7, indiceCuenta);

			Assert.assertTrue(clienteRecaudo.crearClienteRecaudo(numeroCliente, nombreCliente, telefono, contacto,
					correo, celular, direccion));

		} catch (Exception e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

}
