package objectsEdeq;

import java.util.List;

import javax.xml.bind.annotation.XmlList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;
import test.autebtificacion.edeq.LoginEdeqCorrecto;

public class ClienteRecaudoss extends PageBase {

	public ClienteRecaudoss(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
		// TODO Auto-generated constructor stub
	}

	public boolean crearClienteRecaudo(String numeroEmpresa, String nombreEmpreas, String telefono, String contacto,
			String correo, String celular, String direccion) {

		LoginEdeqCorrecto loginEdeq = new LoginEdeqCorrecto();
		loginEdeq.loginCorrecto();
		System.out.println("----------------->" + nombreEmpreas + "<--------------------");

		clickButtonLink(botonMenu);
		clickButtonLink(opcionRecaudo);
		clickButtonLink(pestanaClientesRecaudo);
		sendText(cajatextoNumerocliente, numeroEmpresa);
		sendText(cajatextoNombrecliente, nombreEmpreas);
		sendText(cajatextoTelefono, telefono);
		sendText(cajaTextoContacto, contacto);
		sendText(cajaTextCorreo, correo);
		sendText(cajaTextoCelular, celular);
		sendText(cajatextoDireccion, direccion);
		sendText(cajatextoDireccionCorrespondencia, direccion);
		clickButtonLink(comboBoxDepartamentos);
		esperar(1);
		selectDropdownVisibleText(comboBoxDepartamentos, "Quindio");

		esperar(1);
		clickButtonLink(botonCrear);

		esperar(2);
		return (isElementPresentAndDisplay(msjNotificacion));
	}

	/**
	 * Boton del menu en donde estan todas las opciones
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/div/img")
	private WebElement botonMenu;

	/**
	 * Opcion estructura organizacional del recaudo
	 */
	@FindBy(how = How.ID, using = "menu2")
	private WebElement opcionRecaudo;

	/**
	 * Pestaña de CRUD de los proveedores
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/ul/li[2]/a")
	private WebElement pestanaClientesRecaudo;

	/**
	 * Caja de texto del numero de la cliente de recaudo
	 */
	@FindBy(how = How.ID, using = "NUM_EMPRESA")
	private WebElement cajatextoNumerocliente;

	/**
	 * Caja de texto del nombre de la cliente de recaudo
	 */
	@FindBy(how = How.ID, using = "NOMBRE")
	private WebElement cajatextoNombrecliente;

	/**
	 * Caja de texto del Telefono de la cliente de recaudo
	 */
	@FindBy(how = How.ID, using = "TELEFONO")
	private WebElement cajatextoTelefono;

	/**
	 * Caja de texto del contacto del cliente de recaudo
	 */
	@FindBy(how = How.ID, using = "CONTACTO")
	private WebElement cajaTextoContacto;

	/**
	 * Caja de texto del correo del cliente de recaudo
	 */
	@FindBy(how = How.ID, using = "CORREO")
	private WebElement cajaTextCorreo;

	/**
	 * Caja de texto del numeor de celular del cliente
	 */
	@FindBy(how = How.ID, using = "CELULAR")
	private WebElement cajaTextoCelular;

	/**
	 * Caja de texto de la direccion de la cliente de recaudo
	 */
	@FindBy(how = How.ID, using = "DIRECCION")
	private WebElement cajatextoDireccion;

	/**
	 * Caja de texto de la direccion de correspondencia del de cliente de recaudo
	 */
	@FindBy(how = How.ID, using = "DIR_CORRESPONDENCIA")
	private WebElement cajatextoDireccionCorrespondencia;

	/**
	 * Caja de texto del numeor de la caja SAC de la cliente de recaudo
	 */
	@FindBy(how = How.ID, using = "listDepartamento")
	private WebElement comboBoxDepartamentos;

	/**
	 * Caja de texto del numeor de la caja SAC de la cliente de recaudo
	 */
	@FindBy(how = How.ID, using = "listMunicipio")
	private WebElement comboBoxMunicipio;

	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div[5]/div/div[1]/div/div/select/option[19]")
	private WebElement opcionQuindio;

	/**
	 * Boton para crear el proveedor
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div[7]/div/input")
	private WebElement botonCrear;

	/**
	 * Mensaje que sale cuando se ha insertado un proveedor en el sistema
	 */
	@FindBy(how = How.CLASS_NAME, using = "notificacion")
	private WebElement msjNotificacion;

	//////////////////////// get and set////////////////////////////

	public WebElement getBotonMenu() {
		return botonMenu;
	}

	public void setBotonMenu(WebElement botonMenu) {
		this.botonMenu = botonMenu;
	}

	public WebElement getOpcionRecaudo() {
		return opcionRecaudo;
	}

	public void setOpcionRecaudo(WebElement opcionRecaudo) {
		this.opcionRecaudo = opcionRecaudo;
	}

	public WebElement getPestanaClientesRecaudo() {
		return pestanaClientesRecaudo;
	}

	public void setPestanaClientesRecaudo(WebElement pestanaClientesRecaudo) {
		this.pestanaClientesRecaudo = pestanaClientesRecaudo;
	}

	public WebElement getCajatextoNumerocliente() {
		return cajatextoNumerocliente;
	}

	public void setCajatextoNumerocliente(WebElement cajatextoNumerocliente) {
		this.cajatextoNumerocliente = cajatextoNumerocliente;
	}

	public WebElement getCajatextoNombrecliente() {
		return cajatextoNombrecliente;
	}

	public void setCajatextoNombrecliente(WebElement cajatextoNombrecliente) {
		this.cajatextoNombrecliente = cajatextoNombrecliente;
	}

	public WebElement getCajatextoTelefono() {
		return cajatextoTelefono;
	}

	public void setCajatextoTelefono(WebElement cajatextoTelefono) {
		this.cajatextoTelefono = cajatextoTelefono;
	}

	public WebElement getCajaTextoContacto() {
		return cajaTextoContacto;
	}

	public void setCajaTextoContacto(WebElement cajaTextoContacto) {
		this.cajaTextoContacto = cajaTextoContacto;
	}

	public WebElement getCajaTextCorreo() {
		return cajaTextCorreo;
	}

	public void setCajaTextCorreo(WebElement cajaTextCorreo) {
		this.cajaTextCorreo = cajaTextCorreo;
	}

	public WebElement getCajaTextoCelular() {
		return cajaTextoCelular;
	}

	public void setCajaTextoCelular(WebElement cajaTextoCelular) {
		this.cajaTextoCelular = cajaTextoCelular;
	}

	public WebElement getCajatextoDireccion() {
		return cajatextoDireccion;
	}

	public void setCajatextoDireccion(WebElement cajatextoDireccion) {
		this.cajatextoDireccion = cajatextoDireccion;
	}

	public WebElement getCajatextoDireccionCorrespondencia() {
		return cajatextoDireccionCorrespondencia;
	}

	public void setCajatextoDireccionCorrespondencia(WebElement cajatextoDireccionCorrespondencia) {
		this.cajatextoDireccionCorrespondencia = cajatextoDireccionCorrespondencia;
	}

	public WebElement getComboBoxDepartamentos() {
		return comboBoxDepartamentos;
	}

	public void setComboBoxDepartamentos(WebElement comboBoxDepartamentos) {
		this.comboBoxDepartamentos = comboBoxDepartamentos;
	}

	public WebElement getComboBoxMunicipio() {
		return comboBoxMunicipio;
	}

	public void setComboBoxMunicipio(WebElement comboBoxMunicipio) {
		this.comboBoxMunicipio = comboBoxMunicipio;
	}

	public WebElement getOpcionQuindio() {
		return opcionQuindio;
	}

	public void setOpcionQuindio(WebElement opcionQuindio) {
		this.opcionQuindio = opcionQuindio;
	}

	public WebElement getBotonCrear() {
		return botonCrear;
	}

	public void setBotonCrear(WebElement botonCrear) {
		this.botonCrear = botonCrear;
	}

	public WebElement getMsjNotificacion() {
		return msjNotificacion;
	}

	public void setMsjNotificacion(WebElement msjNotificacion) {
		this.msjNotificacion = msjNotificacion;
	}

}
