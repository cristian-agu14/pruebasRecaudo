package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;
import test.autebtificacion.edeq.LoginEdeqCorrecto;

public class Caja extends PageBase {


	public Caja(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	/**
	 * 
	 * Metodo que ingresa todos los datos para crear la caja
	 * 
	 * @param municipio
	 *            cadena con el nombre de un municipio del quindio
	 * @param sede
	 *            numero de posicion de la sede a crear
	 * @param numeroCaja
	 *            Numero de la caja fisica
	 * @return true si puede crear la caja
	 * @return false si no puede crear la caja
	 */
	public boolean crearCaja(String numeroCaja, String municipio, String sede) {
		
		clickButtonLink(btnMenu);
		clickButtonLink(opcionCajas);
		clickButtonLink(pestanaCajas);
		sendText(cajaTextoNumeroCaja, numeroCaja);
		selectDropdownVisibleText(listaMunicipio,municipio);
		clickButtonLink(btnGrabarCaja);
		return true;
		
	}

	/**
	 * Boton del menu principal
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/div/img")
	private WebElement btnMenu;

	/**
	 * Opcion en la que se encuentra la pestana Cajas
	 */
	@FindBy(how = How.ID, using = "menu8")
	private WebElement opcionCajas;

	/**
	 * Pestana cajas
	 */
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/ul/li[2]/a")
	private WebElement pestanaCajas;

	/**
	 * Caja de texto en donde se ingresa el numero de la que se desea crear
	 */
	@FindBy(how = How.ID, using = "NUMEROCAJA")
	private WebElement cajaTextoNumeroCaja;

	/**
	 * Lista desplegable en la que se encuentran todos los municipios del
	 * departamento
	 */
	@FindBy(how = How.ID, using = "listMunicipio")
	private WebElement listaMunicipio;

	/**
	 * Lista desplegable en la que se encuentran todas
	 */
	@FindBy(how = How.ID, using = "listSede")
	private WebElement listaSede;

	/**
	 * Boton para guardar la nueva caja
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[3]/div/div/input")
	private WebElement btnGrabarCaja;

}
