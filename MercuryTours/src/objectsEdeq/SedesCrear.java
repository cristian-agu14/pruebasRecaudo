package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class SedesCrear extends PageBase {

	public SedesCrear(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	/**
	 * Metodo que inserta la informacion para crear la sede
	 * 
	 * @param nombre
	 * @param direccion
	 * @param municipio
	 * @return True si se encontro en la busqueda de la sede insertada
	 */
	public boolean CrearSede(String nombre, String direccion, String municipio) {
		clickButtonLink(btnAdministracion);
		clickButtonLink(opcionSedes);
		esperar(1);
		clickButtonLink(btnCrearNuevo);
		esperar(1);
		sendText(cajaTextoNombreSede, nombre);
		sendText(cajaTextodireccionSede, direccion);
		clickButtonLink(comboBoxMunicipios);
		seleccionarMunicipio(municipio);
		clickButtonLink(btncrear);
		esperar(3);
		return buscarSede(direccion);

	}

	/**
	 * Metodo que realiza la busqueda de una direccion
	 * 
	 * @param direccion
	 *            texto entrante para realizar la busqueda de esta direccion
	 * @return True
	 */
	public boolean buscarSede(String direccion) {
		esperar(1);
		sendText(cajaTextobusqueda, direccion);
		equals(1);
		clickButtonLink(btnBuscar);
		return isElementPresentAndDisplay(contenedorBusquedas);
	}

	public void seleccionarMunicipio(String municipio) {

		if (municipio.equals("Armenia")) {
			clickButtonLink(comboMunicipioArmenia);
		}

		if (municipio.equals("Buenavista")) {
			clickButtonLink(comboMunicipioBuenavista);
		}

		if (municipio.equals("Calarcá")) {
			clickButtonLink(comboMunicipioCalarca);
		}
		if (municipio.equals("Circasia")) {
			clickButtonLink(comboMunicipioCircasia);
		}
		if (municipio.equals("Cordoba")) {
			clickButtonLink(comboMunicipioCordoba);
		}
		if (municipio.equals("Filandia")) {
			clickButtonLink(comboMunicipioFilandia);
		}
		if (municipio.equals("Génova")) {
			clickButtonLink(comboMunicipioGenova);
		}
		if (municipio.equals("La Tebaida")) {
			clickButtonLink(comboMunicipioTebaida);
		}
		if (municipio.equals("Montenegro")) {
			clickButtonLink(comboMunicipioMontenegro);
		}
		if (municipio.equals("Pijao")) {
			clickButtonLink(comboMunicipioPijao);
		}
		if (municipio.equals("Quimbaya")) {
			clickButtonLink(comboMunicipioQuimbaya);
		}
		if (municipio.equals("Salento")) {
			clickButtonLink(comboMunicipioSalento);
		}

	}

	// Boton de administrador
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[1]/div[1]/div/a[1]")
	private WebElement btnAdministracion;

	// Boton de administrador
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[1]/div[1]/div/ul/li[7]/a")
	private WebElement opcionSedes;

	/**
	 * Boton para abrir el modal en donde se ingresa la informacion de la sede ha
	 * ser guardada
	 */
	@FindBy(how = How.ID, using = "34")
	private WebElement btnCrearNuevo;

	/**
	 * Caja da texto donde se ingresa el nombre de la sede ha ingresar
	 */
	@FindBy(how = How.ID, using = "Sede_NOMBRE")
	private WebElement cajaTextoNombreSede;

	/**
	 * Caja da texto donde se ingresa el nombre de la sede ha ingresar
	 */
	@FindBy(how = How.ID, using = "Sede_DIRECCION")
	private WebElement cajaTextodireccionSede;

	/**
	 * ComboBox en donde se encuentran todos los municipios del quindio
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select")
	private WebElement comboBoxMunicipios;

	/**
	 * Boton para crear la sede
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[4]/div/input")
	private WebElement btncrear;

	/**
	 * Caja de texto para ingredsar la direccion que se desae buscar
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/form/div/div[1]/div/input")
	private WebElement cajaTextobusqueda;

	/**
	 * Boton para hacer las busquedas
	 */
	@FindBy(how = How.ID, using = "True")
	private WebElement btnBuscar;

	/**
	 * Tabla que contiene la informacion de la busqueda
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div/div[2]/div[1]/table/tbody/tr")
	private WebElement contenedorBusquedas;

	/**
	 * Opcion del ComboBox Armenia
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[1]")
	private WebElement comboMunicipioArmenia;

	/**
	 * Opcion del ComboBox Buenavista
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[2]")
	private WebElement comboMunicipioBuenavista;

	/**
	 * Opcion del ComboBox Calarca
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[3]")
	private WebElement comboMunicipioCalarca;

	/**
	 * Opcion del ComboBox Circasia
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[4]")
	private WebElement comboMunicipioCircasia;

	/**
	 * Opcion del ComboBox Cordaba
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[5]")
	private WebElement comboMunicipioCordoba;

	/**
	 * Opcion del ComboBox Filandia
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[6]")
	private WebElement comboMunicipioFilandia;

	/**
	 * Opcion del ComboBox Genova
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[7]")
	private WebElement comboMunicipioGenova;

	/**
	 * Opcion del ComboBox Tebaida
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[8]")
	private WebElement comboMunicipioTebaida;

	/**
	 * Opcion del ComboBox Montenegro
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[9]")
	private WebElement comboMunicipioMontenegro;

	/**
	 * Opcion del ComboBox Pijao
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[10]")
	private WebElement comboMunicipioPijao;

	/**
	 * Opcion del ComboBox Quimbaya
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[11]")
	private WebElement comboMunicipioQuimbaya;

	/**
	 * Opcion del ComboBox Salento
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[12]")
	private WebElement comboMunicipioSalento;

	// ============================Get y Set ====================================

	public WebElement getBtnAdministracion() {
		return btnAdministracion;
	}

	public void setBtnAdministracion(WebElement btnAdministracion) {
		this.btnAdministracion = btnAdministracion;
	}

	public WebElement getOpcionSedes() {
		return opcionSedes;
	}

	public void setOpcionSedes(WebElement opcionSedes) {
		this.opcionSedes = opcionSedes;
	}

	public WebElement getBtnCrearNuevo() {
		return btnCrearNuevo;
	}

	public void setBtnCrearNuevo(WebElement btnCrearNuevo) {
		this.btnCrearNuevo = btnCrearNuevo;
	}

	public WebElement getCajaTextoNombreSede() {
		return cajaTextoNombreSede;
	}

	public void setCajaTextoNombreSede(WebElement cajaTextoNombreSede) {
		this.cajaTextoNombreSede = cajaTextoNombreSede;
	}

	public WebElement getCajaTextodireccionSede() {
		return cajaTextodireccionSede;
	}

	public void setCajaTextodireccionSede(WebElement cajaTextodireccionSede) {
		this.cajaTextodireccionSede = cajaTextodireccionSede;
	}

	public WebElement getComboBoxMunicipios() {
		return comboBoxMunicipios;
	}

	public void setComboBoxMunicipios(WebElement comboBoxMunicipios) {
		this.comboBoxMunicipios = comboBoxMunicipios;
	}

	public WebElement getBtncrear() {
		return btncrear;
	}

	public void setBtncrear(WebElement btncrear) {
		this.btncrear = btncrear;
	}

}
