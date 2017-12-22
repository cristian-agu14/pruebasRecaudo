package test.perfil;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import objectsEdeq.PerfilCrear;
import objectsEdeq.UsuariosCrear;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class Perfil extends TestBase {

	protected UsuariosCrear usuariosCrear;
	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils excelDatosPerfil;

	private String nombrePerfil = "";
	private ArrayList<String> listaPermisos = new ArrayList<>();
	private String idPermiso = "";

	int indice = 2;

	/**
	 * Metodo que prueba la creacion de los perfiles
	 */
	@Test
	private void crearPerfil() {
		PerfilCrear perfilCrear = new PerfilCrear(driver, pageFindFlight);
		try {
			excelDatosPerfil = new ExcelUtils("perfiles.xlsx", ExcelType.XLSX);
			nombrePerfil = excelDatosPerfil.getCellData(indice, 0);

			Assert.assertTrue(perfilCrear.crearPerfil(nombrePerfil, llenarArray()));

		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para llenar el {@link Array} de id de checkBox
	 */
	@SuppressWarnings("finally")
	public ArrayList<String> llenarArray() {
		int i = 1;
		String aux = "";
		try {
			excelDatosPerfil = new ExcelUtils("perfiles.xlsx", ExcelType.XLSX);
			while (aux != null) {
				idPermiso = excelDatosPerfil.getCellData(indice, i);
				listaPermisos.add(idPermiso);
				aux = excelDatosPerfil.getCellData(indice, i + 1);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}finally {
			return listaPermisos;
		}
		//return listaPermisos;
	}

}
