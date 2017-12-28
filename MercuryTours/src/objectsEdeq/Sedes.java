package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;
import test.autebtificacion.edeq.LoginEdeqCorrecto;

public class Sedes extends PageBase {

	private LoginEdeqCorrecto login = new LoginEdeqCorrecto();

	public Sedes(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que ingresa y graba los datos de una sede 
	 * @param nombre
	 * @param direccion
	 * @param municipio
	 * @return
	 */
	private boolean crearsede(String nombre, String direccion, String municipio) {

		return true;
	}

	/**
	 * Boton del menu principal
	 */
	@FindBy(how = How.CLASS_NAME, using = "menuBtn")
	private WebElement btnMenu;

	/**
	 * Opcion en la que se encuentra la pestana Cajas
	 */
	@FindBy(how = How.ID, using = "menu8")
	private WebElement opcionSedes;

	/**
	 * Pestana de la Sede
	 */
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/ul/li[1]/a")
	private WebElement pestanaSedes;

	/**
	 * Caja texto del nombre de la sede
	 */
	@FindBy(how = How.ID, using = "Sede_NOMBRE")
	private WebElement cajaTextoNombreSede;

	/**
	 * Caja de texto de la direccion de la sede
	 */
	@FindBy(how = How.ID, using = "Sede_DIRECCION")
	private WebElement cajaTextoDireccion;

	/**
	 * Lista desplegable de los municipios del quindio
	 */
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[1]/div[3]/div/div/select")
	private WebElement listaMunicipio;

	/**
	 * Boton para guardar los datos ingresados de la sede
	 */
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[2]/div/div/div/input")
	private WebElement btnGrabarSede;
}
