package test.convenios;

import base.TestBase;
import objectsEdeq.Convenio;
import objectsEdeq.CuentasBancarias;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class ConveniosRecaudos extends TestBase {
	
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
	
	public void ingresarConvenio() {
		int indice = 1;
		try {
			convenio = new Convenio(driver, "");
			excelDatosConvenio = new ExcelUtils("convenio.xlsx", ExcelType.XLSX);
			
			numeroConvenio =  excelDatosConvenio.getCellData(1, indice);
			nombreconvenio = excelDatosConvenio.getCellData(2, indice);
			posInicialCodEmpresa = excelDatosConvenio.getCellData(3, indice);
			posFinCodEmpresa = excelDatosConvenio.getCellData(4, indice);
			posInicialReferencia = excelDatosConvenio.getCellData(5, indice);
			posFinalReferencia = excelDatosConvenio.getCellData(6, indice);
			posInicialValor =excelDatosConvenio.getCellData(7, indice);
			posFinValor = excelDatosConvenio.getCellData(8, indice);
			posInicioFecha = excelDatosConvenio.getCellData(9, indice);
			posFinfecha = excelDatosConvenio.getCellData(10, indice);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
