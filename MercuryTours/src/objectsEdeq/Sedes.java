package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class Sedes extends PageBase {

	

	public Sedes(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method that add y save the dates of one headquarters	
	 * 
	 * @param nombre
	 * @param direccion
	 * @param municipio
	 * @return
	 */
	public boolean crearSede(String nombre, String direccion, String municipio) {
		
		clickButtonLink(btnMenu);
		clickButtonLink(opcionSedes);
		clickButtonLink(pestanaSedes);
		sendText(cajaTextoNombreSede, nombre);
		sendText(cajaTextoDireccion, direccion);
		selectDropdownVisibleText(listaMunicipios, municipio);
		//selectDropdownValue(listaMunicipios, municipio);
		//lesperar(2);
		
		clickButtonLink(btnGrabarSede);
		//esperar(1);

		return true;
	}

	/**
	 * Button of menu main
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
	@FindBy(how = How.NAME, using = "Sede.MUNICIPIO_ID")
	private WebElement listaMunicipios;

	/**
	 * Boton para guardar los datos ingresados de la sede
	 */
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[2]/div/div/div/input")
	private WebElement btnGrabarSede;
}
