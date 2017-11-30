package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class CuentasBancarias extends PageBase {

	public CuentasBancarias(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	public boolean CrearCuenta(String nombre, String numero, String banco) {
		clickButtonLink(btnAdministracion);
		clickButtonLink(opcionCuentasBancarias);
		clickButtonLink(btnCrearnuevo);
		esperar(1);
		sendText(cajaTextoNombreCuenta, nombre);
		sendText(numeroCuenta, numero);

	}

	/**
	 * Boton el cual contiene todas las opciones de administrador
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[1]/div[1]/div/a[1]")
	private WebElement btnAdministracion;

	/**
	 * Opcion cuentas bancarias
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[1]/div[1]/div/ul/li[5]/a")
	private WebElement opcionCuentasBancarias;

	/**
	 * Boton para ir a la ventana modan donde se crean las cuentas bancarias nuevas
	 */
	@FindBy(how = How.ID, using = "34")
	private WebElement btnCrearnuevo;

	/**
	 * Caja de texto en donde se ingresa el nombre de la cuenta bancaria
	 */
	@FindBy(how = How.ID, using = "cuentaban_NOMBRE")
	private WebElement cajaTextoNombreCuenta;

	/**
	 * Caja de texto enm donde se ingresa el nombre de la cuenta bancaria
	 */
	@FindBy(how = How.ID, using = "cuentaban_NUMERO_CUENTA")
	private WebElement numeroCuenta;

	/**
	 * ComboBox para seleccionar el banco al cual esta asociado la cuenta
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[3]/div/select")
	private WebElement comboBoxBancos;

	/**
	 * Boton para crear la cuenta bancaria
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[3]/div/div/div/form/div/div[4]/div/input")
	private WebElement btnCrear;

	//////////////////////////////////Get y Set///////////////////////////////////////////

	public WebElement getBtnAdministracion() {
		return btnAdministracion;
	}

	public void setBtnAdministracion(WebElement btnAdministracion) {
		this.btnAdministracion = btnAdministracion;
	}

	public WebElement getOpcionCuentasBancarias() {
		return opcionCuentasBancarias;
	}

	public void setOpcionCuentasBancarias(WebElement opcionCuentasBancarias) {
		this.opcionCuentasBancarias = opcionCuentasBancarias;
	}

	public WebElement getBtnCrearnuevo() {
		return btnCrearnuevo;
	}

	public void setBtnCrearnuevo(WebElement btnCrearnuevo) {
		this.btnCrearnuevo = btnCrearnuevo;
	}

	public WebElement getCajaTextoNombreCuenta() {
		return cajaTextoNombreCuenta;
	}

	public void setCajaTextoNombreCuenta(WebElement cajaTextoNombreCuenta) {
		this.cajaTextoNombreCuenta = cajaTextoNombreCuenta;
	}

	public WebElement getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(WebElement numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public WebElement getComboBoxBancos() {
		return comboBoxBancos;
	}

	public void setComboBoxBancos(WebElement comboBoxBancos) {
		this.comboBoxBancos = comboBoxBancos;
	}

	public WebElement getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(WebElement btnCrear) {
		this.btnCrear = btnCrear;
	}

}
