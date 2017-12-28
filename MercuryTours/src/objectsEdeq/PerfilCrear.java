package objectsEdeq;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;
import test.autebtificacion.edeq.LoginEdeqCorrecto;

public class PerfilCrear extends PageBase {
	private LoginEdeqCorrecto login = new LoginEdeqCorrecto();

	String indiceCheckBox = "";

	public PerfilCrear(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	/**
	 * Metodo que realiza las acciones en la pagina para crear perfil
	 * 
	 * @param nombre,
	 *            del perfil nuevo
	 * @param listaId,
	 *            lista de {@link String} en donde estan los IDs de los permisos
	 * @return una lista de IDs
	 */
	public boolean crearPerfil(String nombre, ArrayList<String> listaId) {
		login.loginCorrecto();
		// esperar(2);
		clickButtonLink(btnMenu);
		// esperar(1);
		clickButtonLink(opcionPerfiles);
		sendText(cajaTextoNombre, nombre);
		seleccionarPerfiles(listaId);
		clickButtonLink(btnAsignarPermisos);
		clickButtonLink(btnGuardarPerfil);
		return true;
	}

	/**
	 * Metodo que selecciona los perfiles que se van a seleccionar
	 * 
	 * @param numeros,
	 *            {@link ArrayList} de IDs
	 * 
	 */
	public void seleccionarPerfiles(ArrayList<String> numeros) {
		for (int i = 0; i < numeros.size(); i++) {
			String aux = (numeros.get(i));
			encontrarCheckBox(aux);
		}

	}

	/**
	 * Boton del menu principal
	 */
	@FindBy(how = How.CLASS_NAME, using = "menuBtn")
	private WebElement btnMenu;

	/**
	 * Opcion en donde se encuetra la pestana perfiles
	 */
	@FindBy(how = How.ID, using = "menu10")
	private WebElement opcionPerfiles;

	/**
	 * Caja de texto en donde se ingresa el nombre del perfil
	 */
	@FindBy(how = How.ID, using = "perfil_NOMBREPERFIL")
	private WebElement cajaTextoNombre;

	/**
	 * Bonton para asignar el permiso y pasarlos a la otra lista en la pantalla
	 */
	@FindBy(how = How.ID, using = "asignarPermiso")
	private WebElement btnAsignarPermisos;

	/**
	 * Boton para guaardar el Perfil con los permisos asignados
	 */
	@FindBy(how = How.ID, using = "guardarPerfil")
	private WebElement btnGuardarPerfil;
}
