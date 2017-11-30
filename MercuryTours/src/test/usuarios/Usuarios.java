package test.usuarios;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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

	/**
	 * Metodo que prueba que se agreguen correctamente los usuarios al sistema
	 */
	@Test
	private void crearUsuario() {
		usuariosCrear = new UsuariosCrear(driver, pageFindFlight);

		try {
			exelDatosUsuarios = new ExcelUtils("usuarios.xlsx", ExcelType.XLSX);
			id = exelDatosUsuarios.getCellData(1, 3);
			nombre = exelDatosUsuarios.getCellData(2, 3);
			perfil = exelDatosUsuarios.getCellData(3, 3);
			nombreUsuario = exelDatosUsuarios.getCellData(4, 3);
			email = exelDatosUsuarios.getCellData(5, 3);

			System.out.println(id);
			System.out.println(nombre);
			System.out.println(perfil);
			System.out.println(nombreUsuario);

			int tipoPerfil = 0;

			tipoPerfil = Integer.parseInt(perfil);

			usuariosCrear.crearUsuario(id, nombre, tipoPerfil, nombreUsuario, email);

			Assert.assertEquals(nombre, usuariosCrear.buscarUsuario(nombre));

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
			id = exelDatosUsuarios.getCellData(1, 1);
			nombre = exelDatosUsuarios.getCellData(2, 1);
			perfil = exelDatosUsuarios.getCellData(3, 1);
			nombreUsuario = exelDatosUsuarios.getCellData(4, 1);
			email = exelDatosUsuarios.getCellData(5, 1);

			System.out.println(id);
			System.out.println(nombre);
			System.out.println(perfil);
			System.out.println(nombreUsuario);

			int tipoPerfil = 0;

			tipoPerfil = Integer.parseInt(perfil);

			usuariosCrear.crearUsuario(id, nombre, tipoPerfil, nombreUsuario, email);
			System.out.println((driver.findElement(By.xpath("//html/body/div[3]/div/div/div/form/div/div[2]/div/span")))
					.getText());
			Assert.assertEquals("Esta identificación ya está registrada",
					(driver.findElement(By.xpath("//html/body/div[3]/div/div/div/form/div/div[2]/div/span")))
							.getText());

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
			id = exelDatosUsuarios.getCellData(1, 1);
			nombre = exelDatosUsuarios.getCellData(2, 1);
			perfil = exelDatosUsuarios.getCellData(3, 1);
			nombreUsuario = exelDatosUsuarios.getCellData(4, 1);
			email = exelDatosUsuarios.getCellData(5, 1);

			System.out.println(id);
			System.out.println(nombre);
			System.out.println(perfil);
			System.out.println(nombreUsuario);

			int tipoPerfil = 0;

			tipoPerfil = Integer.parseInt(perfil);

			usuariosCrear.crearUsuario(id, nombre, tipoPerfil, nombreUsuario, email);
			System.out.println((driver.findElement(By.xpath("//html/body/div[3]/div/div/div/form/div/div[2]/div/span")))
					.getText());
			// assAssert.assertEquals("Esta identificación ya está registrada",
			// (driver.findElement(By.xpath("//html/body/div[3]/div/div/div/form/div/div[2]/div/span"))).getText());

		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

}
