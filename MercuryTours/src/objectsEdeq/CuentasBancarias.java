package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;
import test.autebtificacion.edeq.LoginEdeqCorrecto;

public class CuentasBancarias extends PageBase {

	public CuentasBancarias(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	public boolean crearCuenta(String nombre, String numeroCuenta, boolean tipo, String banco, String cuentaContable) {
		LoginEdeqCorrecto login= new LoginEdeqCorrecto();
		login.loginCorrecto();
		clickButtonLink(btnAdministracion);
		//esperar(1);
		clickButtonLink(opcionCuentasBancarias);
		esperar(1);
		clickButtonLink(pestañaCuentasbancarias);
		esperar(1);
		sendText(cajaTextoNombreCuenta, nombre);
		sendText(cajatextoNumeroCuenta, numeroCuenta);
		sendText(cajaTextoCuentaContable, cuentaContable);
		seleccionarTipocuenta(tipo);
		esperar(1);
		clickButtonLink(btnGuardarCuentaBancaria);	
		esperar(1);
		return buscarCuentaBancaria(numeroCuenta);
	}

	/**
	 * Metodo que selecciona el tipo de cuenta que se va a ingresar
	 * 
	 * @param tipo
	 *            es true si es cuenta contable
	 * @param tipo
	 *            es false si es una cuenta de ahorros
	 */
	public void seleccionarTipocuenta(boolean tipo) {
		if (tipo == true) {
			clickButtonLink(radioButtonCorriente);
		} else {
			clickButtonLink(radioButtonAhorro);
		}
	}
	
	/**
	 * Metodo que busca cuentas bancarias por el numero de cuentas 
	 * @param nuemroCuenta 
	 * @return true si el banco esta registrado
	 * @return false si el banco NO esta registrado
	 */
	public boolean buscarCuentaBancaria(String nuemroCuenta) {
		sendText(cajaTextoBuscador, nuemroCuenta);
		clickButtonLink(btnBuscador);
		esperar(1);
		if(nuemroCuenta.equals(textoPantallaNumeroCuenta.getText())) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Boton el cual contiene todas las opciones de administrador
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/div/img")
	private WebElement btnAdministracion;

	/**
	 * Opcion cuentas bancarias
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/p[2]/a")
	private WebElement opcionCuentasBancarias;

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
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div/div[2]/fieldset/div/form/div/div[5]/div/div/select")
	private WebElement comboBoxBancos;

	/**
	 * Boton para crear la cuenta bancaria
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div/div[2]/fieldset/div/form/div/div[6]/div/div/input")
	private WebElement btnGuardarCuentaBancaria;

	/**
	 * Radio Button que selecciona la cuenta como cuenta de Ahorros
	 */
	@FindBy(how = How.ID, using = "Ahorros")
	private WebElement radioButtonAhorro;

	/**
	 * Radio Button que selecciona la cuenta como cuenta Corriente
	 */
	@FindBy(how = How.ID, using = "Corriente")
	private WebElement radioButtonCorriente;

	/**
	 * Caja de texto en donde se ingresa el nombre de la cuenta bancaria
	 */
	@FindBy(how = How.ID, using = "cuentaban_NOMBRE")
	private WebElement cajaTextoNombre;

	/**
	 * Caja de texxto en donde se ingresa el numero de la cuenta
	 */
	@FindBy(how = How.ID, using = "cuentaban_NUMERO_CUENTA")
	private WebElement cajatextoNumeroCuenta;

	/**
	 * Caja de texto en donde se ingresa el numero de la cuenta contable
	 */
	@FindBy(how = How.ID, using = "cuentaban_CTA_CONTABLE")
	private WebElement cajaTextoCuentaContable;
	
	/**
	 * Boton para guardar los datos de la cuenta bancaria nueva
	 */
	@FindBy(how = How.XPATH, using ="//html/body/div[2]/div[2]/div/div[2]/fieldset/div/form/div/div[6]/div/div/input")
	private WebElement grabarCuentaBancaria;
	
	/**
	 * Pestaña en donde se encuentra todo  lo de cuenta bancaria
	 */
	@FindBy(how =  How.XPATH, using = "//html/body/div[2]/div[2]/div/ul/li[5]/a")
	private WebElement pestañaCuentasbancarias;
	
	/**
	 * Texto del numero de la cuenta bancaria que sale en pantalla 
	 */
	@FindBy(how = How.XPATH, using ="//html/body/div[2]/div[2]/div/div[3]/fieldset/div/div/table/tbody/tr/td[2]")
	private WebElement textoPantallaNumeroCuenta;
	
	/**
	 * Caja de texto del buscador
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div/div[3]/fieldset/div/div/div/div/form/div/div[1]/div/input")
	private WebElement cajaTextoBuscador;
	
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/ul/li[5]/a")
	private WebElement pestanaCuentas;
	
	/**
	 * Boton del buscador
	 */
	@FindBy(how = How.ID, using ="vhwaR")
	private WebElement btnBuscador;

	////////////////////////////////// Get y
	////////////////////////////////// Set///////////////////////////////////////////

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

}
