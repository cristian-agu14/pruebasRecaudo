package test.convenios;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.Convenio;
import objectsEdeq.CuentasBancarias;
import objectsEdeq.LoginEdeq;
import test.autebtificacion.edeq.LoginEdeqCorrecto;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class ConveniosRecaudos extends TestBase {

	LoginEdeqCorrecto loginEdeqCorrecto = new LoginEdeqCorrecto();

	private Convenio convenio;

	private String numeroConvenio = "";

	private String nombreconvenio = "";

	private String observacion = "";

	private String posInicialCodEmpresa = "";

	private String posFinCodEmpresa = "";

	private String posInicialReferencia = "";

	private String posFinalReferencia = "";

	private String posInicialValor = "";

	private String posFinValor = "";

	private String posInicioFecha = "";

	private String posFinfecha = "";
	
	private String cliente="";

	/**
	 * Codigo de la empresa que esta en la primera seccion del codigo de barras
	 */
	private String codigoEmpresa = "";

	private String ip = "";

	private String puerto = "";

	private String ruta;

	private String usuario;

	private String contrasena;

	static ExcelUtils excelDatosConvenio;

	@Test
	public void ingresarConvenio() {

		int indice = 1;

		loginEdeqCorrecto.loginCorrecto();
		try {
			convenio = new Convenio(driver, "");
			excelDatosConvenio = new ExcelUtils("convenios.xlsx", ExcelType.XLSX);

			numeroConvenio = excelDatosConvenio.getCellData(1, indice);
			nombreconvenio = excelDatosConvenio.getCellData(2, indice);
			posInicialCodEmpresa = excelDatosConvenio.getCellData(4, indice);
			posFinCodEmpresa = excelDatosConvenio.getCellData(5, indice);
			posInicialReferencia = excelDatosConvenio.getCellData(6, indice);
			posFinalReferencia = excelDatosConvenio.getCellData(7, indice);
			posInicialValor = excelDatosConvenio.getCellData(8, indice);
			posFinValor = excelDatosConvenio.getCellData(9, indice);
			posInicioFecha = excelDatosConvenio.getCellData(10, indice);
			posFinfecha = excelDatosConvenio.getCellData(11, indice);
			codigoEmpresa = excelDatosConvenio.getCellData(12, indice);
			ip = excelDatosConvenio.getCellData(13, indice);
			puerto = excelDatosConvenio.getCellData(14, indice);
			ruta = excelDatosConvenio.getCellData(15, indice);
			usuario = excelDatosConvenio.getCellData(16, indice);
			contrasena = excelDatosConvenio.getCellData(17, indice);
			cliente = excelDatosConvenio.getCellData(18, indice);

			Assert.assertTrue(convenio.crearConvenioRecaudo(numeroConvenio, nombreconvenio, posInicialCodEmpresa,
					posFinCodEmpresa, posInicialReferencia, posFinalReferencia, posInicialValor, posFinValor,
					posInicioFecha, posFinfecha, ip, puerto, ruta, usuario, contrasena,cliente, codigoEmpresa));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
