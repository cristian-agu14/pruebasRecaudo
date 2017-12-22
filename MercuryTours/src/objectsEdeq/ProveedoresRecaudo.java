package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;
import test.autebtificacion.edeq.LoginEdeqCorrecto;

public class ProveedoresRecaudo extends PageBase {

	public ProveedoresRecaudo(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
		// TODO Auto-generated constructor stub
	}

	public boolean crearProveedor(String numero, String nombre, String telefono, String direccion, String cjaSAC,
			String formatoRecaudo) {
		LoginEdeqCorrecto loginEdeqCorrecto = new LoginEdeqCorrecto();
		loginEdeqCorrecto.loginCorrecto();
		clickButtonLink(btnMenu);
		clickButtonLink(opcionProveedor);
		clickButtonLink(pestanaProveedor);
		sendText(cajaTextoNumero, numero);
		sendText(cajaTextoNombre, nombre);
		sendText(cajaTextoTelefono, telefono);
		sendText(cajaTextoDireccion, direccion);
		sendText(cajaTextoCajaSAC, cjaSAC);
		sendText(cajaTextoFormatoRecaudo, formatoRecaudo);
		clickButtonLink(btnCrearProveedor);
		
		return true;
	}

	/**
	 * Boton del menu principal
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/div/img")
	private WebElement btnMenu;

	/**
	 * Opcion en donde se encuentra la pestana proveedor
	 */
	@FindBy(how = How.ID, using = "menu2")
	private WebElement opcionProveedor;

	/**
	 * Pestana del proveedor de recaudo
	 */
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/ul/li[3]/a")
	private WebElement pestanaProveedor;

	/**
	 * caja de texto numero de la empresa de proveedor de recaudo
	 */
	@FindBy(how = How.ID, using = "NUMERO_EMPRESA")
	private WebElement cajaTextoNumero;

	/**
	 * Caja de texto del nombre del la empresa proveedora de recaudo
	 */
	@FindBy(how = How.ID, using = "NOMBRE_EMPRESA")
	private WebElement cajaTextoNombre;

	/**
	 * Caja de texto del numero de telefono del la empresa proveedora de recaudo
	 */
	@FindBy(how = How.ID, using = "TELEFONO")
	private WebElement cajaTextoTelefono;

	/**
	 * Caja de texto de la direccion de la empresa proveedora de recaudo
	 */
	@FindBy(how = How.ID, using = "DIRECCION")
	private WebElement cajaTextoDireccion;

	/**
	 * Caja de texto del numero de caja SAC de la empresa proveedora de recaudo
	 */
	@FindBy(how = How.ID, using = "NUMERO_CAJA_SAC")
	private WebElement cajaTextoCajaSAC;

	/**
	 * Caja de texto del formato de recaudo de la empresa proveedora de recaudo
	 */
	@FindBy(how = How.ID, using = "FORMATO_RECAUDO")
	private WebElement cajaTextoFormatoRecaudo;

	/**
	 * Boton para ingresar el proveedor de recaudo 
	 */
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[3]/div/div/input")
	private WebElement btnCrearProveedor;

}
