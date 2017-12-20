package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;
import test.autebtificacion.edeq.LoginEdeqCorrecto;

public class ProveedoresCrear extends PageBase {

	public ProveedoresCrear(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
		// TODO Auto-generated constructor stub
	}

	public boolean crearProveedor(String numeroEmpresa, String nombreEmpresa, String telefono, String direccion, String cajaSAC, String formatoRecaudo) {
		
		LoginEdeqCorrecto loginEdeq = new LoginEdeqCorrecto();
		loginEdeq.loginCorrecto();
		
		clickButtonLink(botonMenu);
		clickButtonLink(opcionRecaudo);
		clickButtonLink(pestanaProveedores);
		sendText(cajatextoNumeroEmpresa,numeroEmpresa);
		sendText(cajatextoNombreEmpresa, nombreEmpresa);
		sendText(cajatextoTelefono, telefono);
		sendText(cajatextoDireccion, direccion);
		sendText(cajatextoCajaSAC, cajaSAC);
		sendText(cajatextoFormatoRecaudo, formatoRecaudo);
		clickButtonLink(botonCrear);
		esperar(2);
		return(isElementPresentAndDisplay(msjNotificacion));		
	}

	/**
	 * Boton del menu en donde estan todas las opciones
	 */
	@FindBy(how = How.CLASS_NAME, using = "menuBtn")
	private WebElement botonMenu;

	/**
	 * Opcion estructura organizacional del recaudo
	 */
	@FindBy(how = How.ID, using = "menu2")
	private WebElement opcionRecaudo;

	/**
	 * Pestaña de CRUD de los proveedores
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/ul/li[3]/a")
	private WebElement pestanaProveedores;

	/**
	 * Caja de texto del numero de la empresa
	 */
	@FindBy(how = How.ID, using = "NUMERO_EMPRESA")
	private WebElement cajatextoNumeroEmpresa;

	/**
	 * Caja de texto del nombre de la empresa
	 */
	@FindBy(how = How.ID, using = "NOMBRE_EMPRESA")
	private WebElement cajatextoNombreEmpresa;

	/**
	 * Caja de texto del Telefono de la empresa
	 */
	@FindBy(how = How.ID, using = "TELEFONO")
	private WebElement cajatextoTelefono;

	/**
	 * Caja de texto de la direccion de la empresa
	 */
	@FindBy(how = How.ID, using = "DIRECCION")
	private WebElement cajatextoDireccion;

	/**
	 * Caja de texto del numeor de la caja SAC de la empresa
	 */
	@FindBy(how = How.ID, using = "NUMERO_CAJA_SAC")
	private WebElement cajatextoCajaSAC;
	
	
	/**
	 * Caja de texto del numeor de la caja SAC de la empresa
	 */
	@FindBy(how = How.ID, using = "FORMATO_RECAUDO")
	private WebElement cajatextoFormatoRecaudo;

	/**
	 * Boton para crear el proveedor
	 */
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[3]/div/div/input")
	private WebElement botonCrear;
	
	/**
	 * Mensaje que sale cuando se ha insertado un proveedor en el sistema
	 */
	@FindBy(how = How.CLASS_NAME, using ="notificacion")
	private WebElement msjNotificacion;

}
