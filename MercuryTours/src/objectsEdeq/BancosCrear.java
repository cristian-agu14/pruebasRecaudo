package objectsEdeq;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;
import test.autebtificacion.edeq.LoginEdeqCorrecto;

public class BancosCrear extends PageBase {

	private BancosCrearVentana2 bancosCrearVentana2;
	

	public BancosCrear(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo que crear los bancos
	 * 
	 * @param nombreBanco
	 *            nombre del banco que le va a ingresar
	 * @throws InterruptedException
	 */
	public boolean crearBancos(String nombreBanco, String codigo) throws InterruptedException {

		clickButtonLink(btnAdministracion);
		clickButtonLink(btnOpcionBancos);
		//clickButtonLink(btnCrearNuevoBanco);
		//esperar(3);// Espera 5 segundos para dar tiempo a la pantalla
		driver.findElement(By.id("NOMBRE")).clear();

		driver.findElement(By.id("NOMBRE")).sendKeys(nombreBanco);
		cajaTextoCodigo.sendKeys(codigo);
		clickButtonLink(btnGuardar);
		return(isElementPresentAndDisplay(mensajeConfirmacion));
		//clickButtonLink(btnCrear);
		//driver.findElement(By.xpath("//input[@value='Guardar']")).click();
		//esperar(3);

//		cajatextobuscador.click();
//		cajatextobuscador.sendKeys(nombreBanco);
//		cajaTextoNombre.sendKeys(nombreBanco);
//		clickButtonLink(btnBuscar);
//		esperar(3);

		// sendText(cajaTextoNombre, nombreBanco);
		// clickButtonLink(btnCrear);
	}

	/**
	 * Metodo para intentar crear un banco con numeros
	 * 
	 * @param nombreBanco
	 *            nombre del banco, deberia contener numeros
	 * @throws InterruptedException
	 */
	public String crearBancosConNumeros(String nombreBanco) throws InterruptedException {
		String msj = "";
		clickButtonLink(btnAdministracion);
		clickButtonLink(btnOpcionBancos);
		clickButtonLink(btnCrearNuevoBanco);
		esperar(3);// Espera 5 segundos para dar tiempo a la pantalla
		driver.findElement(By.id("NOMBRE")).clear();
		driver.findElement(By.id("NOMBRE")).sendKeys(nombreBanco);

		driver.findElement(By.xpath("//input[@value='Guardar']")).click();
		esperar(2);
		msj = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/div/div[2]/div/div/span")).getText();
		System.out.println("----------------->" + msj + "<-----------------------");

		return msj;
	}

	/**
	 * Metodo para intentar crear un banco REPETIDO
	 * 
	 * @param nombreBanco
	 *            nombre del banco, deberia contener numeros
	 * @throws InterruptedException
	 */
	public String crearBancosRepetido(String nombreBanco) throws InterruptedException {
		String msj = "";
		clickButtonLink(btnAdministracion);
		clickButtonLink(btnOpcionBancos);
		clickButtonLink(btnCrearNuevoBanco);
		esperar(3);// Espera 5 segundos para dar tiempo a la pantalla
		driver.findElement(By.id("NOMBRE")).clear();
		driver.findElement(By.id("NOMBRE")).sendKeys(nombreBanco);

		driver.findElement(By.xpath("//input[@value='Guardar']")).click();
		esperar(2);
		msj = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/div/div[2]/div/div/span")).getText();
		System.out.println("----------------->" + msj + "<-----------------------");

		return msj;
	}

	/**
	 * Metodo para buscar un banco registrado con anterioridad
	 * 
	 * @param nombreBanco
	 *            nombre del banco
	 * @throws InterruptedException
	 */
	public String buscarBancoExitente(String nombreBanco) throws InterruptedException {
		String msj = "";
		clickButtonLink(btnAdministracion);
		clickButtonLink(btnOpcionBancos);
		esperar(2);// Espera 5 segundos para dar tiempo a la pantalla
		cajatextobuscador.click();
		cajatextobuscador.sendKeys(nombreBanco);
		btnBuscar.click();
		esperar(2);
		cajatextobuscador.sendKeys(nombreBanco);
		btnBuscar.click();

		msj = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[1]/table/tbody/tr/td[1]")).getText();
		System.out.println("----------------->" + msj + "<-----------------------");

		return msj;
	}

	// variable que pone en espera la prueba
	private WebDriverWait wait;

	// Boton de administrador
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/div/img")
	private WebElement btnAdministracion;

	// Boton de administrador
	@FindBy(how = How.ID, using = "menu2")
	private WebElement btnOpcionBancos;

	// Boton para crear un nuevo banco
	@FindBy(how = How.ID, using = "34")
	private WebElement btnCrearNuevoBanco;

	// Caja de texto para ingresar el nombre del banco a crear
	@FindBy(how = How.ID, using = "NOMBRE")
	private WebElement cajaTextoNombre;

	// Boton para crear ingresar el banco a la base de datos
	@FindBy(how = How.CLASS_NAME, using = "btn btn-default send")
	private WebElement btnCrear;

	@FindBy(how = How.CLASS_NAME, using = "toast-message")
	private WebElement msjValidacion;

	// ventana emergente
	@FindBy(how = How.CLASS_NAME, using = "modal-body")
	private WebElement ventanaemergente;

	// Campo de texto para ingresar las busquedas
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div/div[3]/fieldset/div/div/div/form/div/div[1]/div/input")
	private WebElement cajatextobuscador;

	// boton para realizar las busquedas
	@FindBy(how = How.ID, using = "jlREc")
	private WebElement btnBuscar;

	// campo en donde queda la busqueda realizada
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]")
	private WebElement campoBusqueda;

	// Campo de texto donde sale el mensaje que solo se permiten letras
	@FindBy(how = How.CLASS_NAME, using = "field-validation-error text-danger")
	private WebElement textoSoloLetras;
	
	/**
	 *Mensaje de notificacion 
	 */
	@FindBy(how =  How.CLASS_NAME, using = "notificacion")
	private WebElement mensajeConfirmacion;
	

	
	
	/**
	 * Boton para guardar el nuevo banco
	 */								   
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div/div/div[3]/input")
	private WebElement btnGuardar;
	
	/**
	 * Caja de texto para ingresar el codigo del banco
	 */
	@FindBy(how = How.ID, using = "CODIGO")
	private WebElement cajaTextoCodigo; 

	/**
	 * geters and seters
	 * 
	 * @return
	 */

	public WebElement getBtnAdministracion() {
		return btnAdministracion;
	}

	public WebElement getTextoSoloLetras() {
		return textoSoloLetras;
	}

	public void setTextoSoloLetras(WebElement textoSoloLetras) {
		this.textoSoloLetras = textoSoloLetras;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}

	public WebElement getCajatextobuscador() {
		return cajatextobuscador;
	}

	public void setCajatextobuscador(WebElement cajatextobuscador) {
		this.cajatextobuscador = cajatextobuscador;
	}

	public WebElement getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(WebElement btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public WebElement getCampoBusqueda() {
		return campoBusqueda;
	}

	public void setCampoBusqueda(WebElement campoBusqueda) {
		this.campoBusqueda = campoBusqueda;
	}

	public BancosCrearVentana2 getBancosCrearVentana2() {
		return bancosCrearVentana2;
	}

	public void setBancosCrearVentana2(BancosCrearVentana2 bancosCrearVentana2) {
		this.bancosCrearVentana2 = bancosCrearVentana2;
	}

	public WebElement getVentanaemergente() {
		return ventanaemergente;
	}

	public void setVentanaemergente(WebElement ventanaemergente) {
		this.ventanaemergente = ventanaemergente;
	}

	public void setBtnAdministracion(WebElement btnAdministracion) {
		this.btnAdministracion = btnAdministracion;
	}

	public WebElement getBtnOpcionBancos() {
		return btnOpcionBancos;
	}

	public void setBtnOpcionBancos(WebElement opcionBancos) {
		this.btnOpcionBancos = opcionBancos;
	}

	public WebElement getBtnCrearNuevoBanco() {
		return btnCrearNuevoBanco;
	}

	public void setBtnCrearNuevoBanco(WebElement btnCrearNuevoBanco) {
		this.btnCrearNuevoBanco = btnCrearNuevoBanco;
	}

	public WebElement getCajaTextoNombre() {
		return cajaTextoNombre;
	}

	public void setCajaTextoNombre(WebElement cajaTextoNombre) {
		this.cajaTextoNombre = cajaTextoNombre;
	}

	public WebElement getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(WebElement btnCrear) {
		this.btnCrear = btnCrear;
	}

	public WebElement getMsjValidacion() {
		return msjValidacion;
	}

	public void setMsjValidacion(WebElement msjValidacion) {
		this.msjValidacion = msjValidacion;
	}

}
