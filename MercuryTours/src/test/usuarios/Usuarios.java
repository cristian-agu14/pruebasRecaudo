package test.usuarios;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.OaIdl.ELEMDESC._ELEMDESC;

import base.TestBase;
import objectsEdeq.UsuariosCrear;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class Usuarios extends TestBase {

	protected UsuariosCrear usuariosCrear;
	private String pageFindFlight = "Find a Flight: Edeq";
	static ExcelUtils exelDatosUsuarios;

	String id = "";
	String nombre = "";
	String perfil = "";
	String nombreUsuario = "";
	String email = "";
	int indiceUser = 3;

	/**
	 * Metodo que prueba que se agreguen correctamente los usuarios al sistema
	 */
	@Test
	private void crearUsuario() {
		usuariosCrear = new UsuariosCrear(driver, pageFindFlight);

		try {
			// hay datos en el excel hasta 9
			exelDatosUsuarios = new ExcelUtils("usuarios.xlsx", ExcelType.XLSX);
			id = exelDatosUsuarios.getCellData(1, indiceUser);
			nombre = exelDatosUsuarios.getCellData(2, indiceUser);
			perfil = exelDatosUsuarios.getCellData(3, indiceUser);

			nombreUsuario = exelDatosUsuarios.getCellData(4, indiceUser);
			email = exelDatosUsuarios.getCellData(5, indiceUser);

			System.out.println(id);
			System.out.println(nombre);
			System.out.println(perfil);
			System.out.println(nombreUsuario);

			int tipoPerfil = 0;

			tipoPerfil = Integer.parseInt(perfil);

			usuariosCrear.crearUsuario(id, nombre, tipoPerfil, nombreUsuario, email);

			// Assert.assertTrue(usuariosCrear.buscarUsuario(nombre));
			// Assert.assertFalse(driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/fieldset/div/div/form/div/div[7]/div/div/a")).isDisplayed());
			Assert.assertFalse(usuariosCrear.buscarUsuario(id));

		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que prueba la restriccion de ingresos de usuarios repetidos
	 */
	@Test
	private void crearUsuarioIdRepetido() {

		usuariosCrear = new UsuariosCrear(driver, pageFindFlight);

		try {
			exelDatosUsuarios = new ExcelUtils("usuarios.xlsx", ExcelType.XLSX);
			id = exelDatosUsuarios.getCellData(1, indiceUser);
			nombre = exelDatosUsuarios.getCellData(2, indiceUser);
			perfil = exelDatosUsuarios.getCellData(3, indiceUser);
			nombreUsuario = exelDatosUsuarios.getCellData(4, indiceUser);
			email = exelDatosUsuarios.getCellData(5, indiceUser);

			System.out.println(id);
			System.out.println(nombre);
			System.out.println(perfil);
			System.out.println(nombreUsuario);

			int tipoPerfil = 0;

			tipoPerfil = Integer.parseInt(perfil);

			usuariosCrear.crearUsuario(id, nombre, tipoPerfil, nombreUsuario, email);

			Assert.assertTrue(usuariosCrear.comprobarTextos());

		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que prueba la restriccion de ingresos de usuarios cOn USUARIOS
	 * repetidos
	 */
	@Test
	private void crearUsuarionNikrepetido() {

		usuariosCrear = new UsuariosCrear(driver, pageFindFlight);

		try {
			exelDatosUsuarios = new ExcelUtils("usuarios.xlsx", ExcelType.XLSX);
			id = exelDatosUsuarios.getCellData(1, indiceUser);
			nombre = exelDatosUsuarios.getCellData(2, indiceUser);
			perfil = exelDatosUsuarios.getCellData(3, indiceUser);
			nombreUsuario = exelDatosUsuarios.getCellData(4, indiceUser);
			email = exelDatosUsuarios.getCellData(5, indiceUser);

			System.out.println(id);
			System.out.println(nombre);
			System.out.println(perfil);
			System.out.println(nombreUsuario);

			int tipoPerfil = 0;

			tipoPerfil = Integer.parseInt(perfil);

			usuariosCrear.crearUsuario(id, nombre, tipoPerfil, nombreUsuario, email);
			// System.out.println((driver.findElement(By.xpath("//html/body/div[3]/div/div/div/form/div/div[2]/div/span")))
			// .getText());
			// assAssert.assertEquals("Esta identificación ya está registrada",
			// (driver.findElement(By.xpath("//html/body/div[3]/div/div/div/form/div/div[2]/div/span"))).getText());
			Assert.assertTrue(usuariosCrear.comprobarTextos());

		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

}
