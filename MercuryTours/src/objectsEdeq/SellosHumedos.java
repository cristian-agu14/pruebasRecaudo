package objectsEdeq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class SellosHumedos extends PageBase {

	/**
	 * Constructor
	 * 
	 * @param driver
	 * @param pageTitle
	 */
	public SellosHumedos(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	/**
	 * Metodo que crea un sello humdo y lo asigna a un cajero en especifico
	 * 
	 * @param numerosSello
	 *            numero entero y unico del sello humedo
	 * @param cajero
	 *            numero entero que corresponde a una posicion de la lista de
	 *            usuarios del comboBox
	 */
	public boolean crearSellohumedo(String numerosSello, String cajero) {
		ingresarAgregarSello(numerosSello, cajero);
		return buscar(cajero);

	}

	/**
	 * Metodo para ingresar a la ventana Crear Sello Humedo
	 * 
	 * @param numerosSellonumero
	 *            entero y unico del sello humedo
	 * @param cajero
	 *            numero entero que corresponde a una posicion de la lista de
	 *            usuarios del comboBox
	 */
	public void ingresarAgregarSello(String numerosSello, String cajero) {

		clickButtonLink(btnAdministracion);
		clickButtonLink(btnSelloshumedos);
		clickButtonLink(btnCrearNuevoSello);
		esperar(1);
		sendText(cajaTextoNumerosello, numerosSello);
		clickButtonLink(comboBoxListaCajero);
		esperar(1);
		seleccionarCajero(cajero);
		clickButtonLink(btnGuardar);
		esperar(2);

	}

	/**
	 * Metodo para seleccionar un cajero de una lista de cajeros
	 */
	public void seleccionarCajero(String numCajero) {
		if (numCajero.equals("1")) {
			clickButtonLink(opcionCajero_1);
		}
		if (numCajero.equals("2")) {
			clickButtonLink(opcionCajero_2);
		}
		if (numCajero.equals("3")) {
			clickButtonLink(opcionCajero_3);

		}
	}

	/**
	 * Metodo que busca por el numero de sello humedo
	 * 
	 * @param busqueda
	 *            valor entero del sello humedo
	 * @return true si encuentra el numero en la busqueda
	 * @return False si no encuentra el numero en la busqueda
	 */
	public boolean buscar(String busqueda) {
		sendText(cajaTextoBuscador, busqueda);
		clickButtonLink(btnBuscar);
		esperar(5);
		if (driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[2]/div[1]/table/tbody/tr/td[1]")) != null) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * Mensaje que sale cuando ya se ha asignado un sello humedo con ese numero
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/div/span")
	private WebElement msjErrorSelloHumedo;
	
	/**
	 * Mensaje que sale cuando ya se le ha asignado un sello humedo a ese Cajero
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[4]/div/span")
	private WebElement msjErrorCajeroconSellohumedo;

	/**
	 * Caja de texto para ingresar las busquedas
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/form/div/div[1]/div/input")
	private WebElement cajaTextoBuscador;

	/**
	 * Boton para hacer la busqueda
	 */
	@FindBy(how = How.ID, using = "True")
	private WebElement btnBuscar;

	/**
	 * Boton administracion de la lista desplegable
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[1]/div[1]/div/a[1]")
	private WebElement btnAdministracion;

	/**
	 * Opcion sellos humedos en la lista de despliegue
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[1]/div[1]/div/ul/li[4]/a")
	private WebElement btnSelloshumedos;

	/**
	 * Boton Crear nuevo, para asignar un nuevo sello humedo
	 */
	@FindBy(how = How.ID, using = "34")
	private WebElement btnCrearNuevoSello;

	/**
	 * Caja de texto en donde se ingresa el numero del sello humedo
	 */
	@FindBy(how = How.ID, using = "selloHumedo_NUMERO_SELLO")
	private WebElement cajaTextoNumerosello;

	/**
	 * Combo box en donde se encuentran todos los cajeros
	 */
	@FindBy(how = How.ID, using = "listCajero")
	private WebElement comboBoxListaCajero;

	/**
	 * Boton Para guardar la asignacion de un sello humedo a un cajero en especifico
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[4]/div/input")
	private WebElement btnGuardar;

	/**
	 * Opcion 1 de la lista de Cajeros
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[1]")
	private WebElement opcionCajero_1;

	/**
	 * Opcion 2 de la lista de Cajeros
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[2]")
	private WebElement opcionCajero_2;

	/**
	 * Opcion 3 de la lista de Cajeros
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select/option[3]")
	private WebElement opcionCajero_3;

	public WebElement getBtnAdministracion() {
		return btnAdministracion;
	}

	public void setBtnAdministracion(WebElement btnAdministracion) {
		this.btnAdministracion = btnAdministracion;
	}

	public WebElement getBtnSelloshumedos() {
		return btnSelloshumedos;
	}

	public void setBtnSelloshumedos(WebElement btnSelloshumedos) {
		this.btnSelloshumedos = btnSelloshumedos;
	}

	public WebElement getBtnCrearNuevoSello() {
		return btnCrearNuevoSello;
	}

	public void setBtnCrearNuevoSello(WebElement btnCrearNuevoSello) {
		this.btnCrearNuevoSello = btnCrearNuevoSello;
	}

	public WebElement getCajaTextoNumerosello() {
		return cajaTextoNumerosello;
	}

	public void setCajaTextoNumerosello(WebElement cajaTextoNumerosello) {
		this.cajaTextoNumerosello = cajaTextoNumerosello;
	}

	public WebElement getComboBoxListaCajero() {
		return comboBoxListaCajero;
	}

	public void setComboBoxListaCajero(WebElement comboBoxListaCajero) {
		this.comboBoxListaCajero = comboBoxListaCajero;
	}

	public WebElement getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(WebElement btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public WebElement getMsjErrorSelloHumedo() {
		return msjErrorSelloHumedo;
	}

	public void setMsjErrorSelloHumedo(WebElement msjErrorSelloHumedo) {
		this.msjErrorSelloHumedo = msjErrorSelloHumedo;
	}

	public WebElement getMsjErrorCajeroconSellohumedo() {
		return msjErrorCajeroconSellohumedo;
	}

	public void setMsjErrorCajeroconSellohumedo(WebElement msjErrorCajeroconSellohumedo) {
		this.msjErrorCajeroconSellohumedo = msjErrorCajeroconSellohumedo;
	}

	public WebElement getCajaTextoBuscador() {
		return cajaTextoBuscador;
	}

	public void setCajaTextoBuscador(WebElement cajaTextoBuscador) {
		this.cajaTextoBuscador = cajaTextoBuscador;
	}

	public WebElement getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(WebElement btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public WebElement getOpcionCajero_1() {
		return opcionCajero_1;
	}

	public void setOpcionCajero_1(WebElement opcionCajero_1) {
		this.opcionCajero_1 = opcionCajero_1;
	}

	public WebElement getOpcionCajero_2() {
		return opcionCajero_2;
	}

	public void setOpcionCajero_2(WebElement opcionCajero_2) {
		this.opcionCajero_2 = opcionCajero_2;
	}

	public WebElement getOpcionCajero_3() {
		return opcionCajero_3;
	}

	public void setOpcionCajero_3(WebElement opcionCajero_3) {
		this.opcionCajero_3 = opcionCajero_3;
	}
	

}
