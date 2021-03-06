package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;
import test.autebtificacion.edeq.LoginEdeqCorrecto;

public class UsuariosCrear extends PageBase {
	
	private LoginEdeqCorrecto login= new LoginEdeqCorrecto();
	
	public UsuariosCrear(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo para crear usuarios
	 * 
	 * @param identificacion
	 *            del usuario
	 * @param nombre
	 * @param perfil
	 * @param nombreUsuario
	 */
	public void crearUsuario(String identificacion, String nombre, int perfil, String nombreUsuario, String email) {

		login.loginCorrecto();
		esperar(1);
		
		clickButtonLink(btnAdministracion);
		clickButtonLink(btnUsuarios);
		clickButtonLink(pestanaUsuarios);
		// clickButtonLink(btnCrearUsuario);
		esperar(1);
		String id = String.valueOf(identificacion);
		// esperar(1);
		sendText(cajatextoIdentificacion, id);
		// esperar(1);
		sendText(cajatextoNombre, nombre);
		// esperar(1);
		clickButtonLink(comboBoxPerfil);
		selectDropdownVisibleText(comboBoxPerfil, "Cajero");
		//esperar(1);
		sendText(cajaTextoNombreUsuario, nombreUsuario);
		sendText(cajaTextoEmail, email);
		clickButtonLink(btnGuardarUsuario);
		esperar(3);
	}

	/**
	 * Metodo para seleccionar el tipo de usuario a ingresar
	 * 
	 * @param tipo
	 *            entero para identificar el tipo
	 */
	public void ingresarTipoUsuario(int tipo) {
		if (tipo == 1) {
			clickButtonLink(comboBoxPerfil_1);
		}
		if (tipo == 2) {
			clickButtonLink(comboBoxPerfil_2);
		}
		if (tipo == 3) {
			clickButtonLink(comboBoxPerfil_3);
		}
		if (tipo == 4) {
			clickButtonLink(comboBoxPerfil_4);
		}
		if (tipo == 5) {
			clickButtonLink(comboBoxPerfil_5);
		}

	}

	/**
	 * Metodo para buscar un banco registrado con anterioridad
	 * 
	 * @param nombreBanco
	 *            nombre del banco
	 * @throws InterruptedException
	 */
	public boolean buscarUsuario(String nombreUsuario) throws InterruptedException {
		String msj = "";
		clickButtonLink(btnAdministracion);
		clickButtonLink(btnUsuarios);
		esperar(2);// Espera 5 segundos para dar tiempo a la pantalla
		clickButtonLink(cajaTextoBuscador);
		esperar(1);
		sendText(cajaTextoBuscador, nombreUsuario);
		esperar(1);
		clickButtonLink(btnBuscador);
		esperar(2);
		// cajatextobuscador.sendKeys(nombreBanco);
		// btnBuscar.click();

		// msj =
		// driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div[3]/fieldset/div/div/div/table/tbody/tr/td[1]"))
		// .getText();
		//System.out.println("-------------------------->" + textobusqueda.getText() + "<----------------------");
		//System.out.println("------------------>" + textobusqueda.isDisplayed()+ "<------------------------");
		if (isElementPresentAndDisplay(textobusqueda)) {
			return true;

		} else {
			return false;
		}
	}
	
	
	public boolean comprobarTextos() {
		if(isElementPresentAndDisplay(textoIdRepetido)) {
			return true;
		}else {
			return false;
		}
		
	}

	/**
	 * Opcion usuarios
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/p[1]/a")
	private WebElement btnUsuarios;

	// Boton de administrador
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/div/img")
	private WebElement btnAdministracion;

	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/div/form/div/div[2]/div[1]/div/div/span")
	private WebElement textoIdRepetido;

	/**
	 * boton para crear un nuevo usuario
	 */
	@FindBy(how = How.ID, using = "34")
	private WebElement btnCrearUsuario;

	/**
	 * Caja de texto para ingresar el numero de identificacion del usuario
	 */
	@FindBy(how = How.ID, using = "Usuario_IDENTIFICACION")
	private WebElement cajatextoIdentificacion;

	/**
	 * Caja de texto para ingresar el nombre del usuario
	 */
	@FindBy(how = How.ID, using = "Usuario_NOMBRE")
	private WebElement cajatextoNombre;

	/**
	 * ComboBox donde se encuentran todos los perfiles que se pueden elegir para un
	 * usuario
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[1]/div[3]/div/div/select")
	private WebElement comboBoxPerfil;

	/**
	 * Perfil 1 del comboBox que equivale al perfil ADMINISTRADOR
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[1]/div[3]/div/div/select/option[1]")
	private WebElement comboBoxPerfil_1;

	/**
	 * Perfil 2 del comboBox que equivale al perfil CAJERO
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[1]/div[3]/div/div/select/option[2]")
	private WebElement comboBoxPerfil_2;

	/**
	 * Perfil 3 del comboBox que equivale al perfil COORDINADOR
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[1]/div[3]/div/div/select/option[3]")
	private WebElement comboBoxPerfil_3;

	/**
	 * Perfil 4 del comboBox que equivale al perfil JEFE DE RECAUDO
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[1]/div[3]/div/div/select/option[4]")
	private WebElement comboBoxPerfil_4;

	/**
	 * Perfil 5 del comboBox que equivale al perfil TESORERO
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[1]/div[3]/div/div/select/option[4]")
	private WebElement comboBoxPerfil_5;

	/**
	 * Caja de texto para ingresar el nombre de usurio del sistema para un usuario
	 */
	@FindBy(how = How.ID, using = "Usuario_NICKNAME")
	private WebElement cajaTextoNombreUsuario;

	/**
	 * Boton para guardar el usurio nuevo
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div/div[3]/div/div/input")
	private WebElement btnGuardarUsuario;

	/**
	 * Caja de texto buscados
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div/div[3]/fieldset/div/div/div/form/div/div[1]/div/input")
	private WebElement cajaTextoBuscador;

	/**
	 * Boton del bucador de usuarios
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[3]/fieldset/div/div/div/form/div/div[2]/input")
	private WebElement btnBuscador;

	/**
	 * Caja de texto para ingresar el Email del usuario
	 */
	@FindBy(how = How.ID, using = "Usuario_CORREO")
	private WebElement cajaTextoEmail;

	/**
	 * Texto que sale al buscar un usuario
	 */
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[3]/fieldset/div/div/div/div/div/div/div/form/div/div[2]/input")
	private WebElement textobusqueda;
	
	@FindBy(how = How.XPATH, using="//html/body/div[2]/div[2]/div[2]/ul/li[2]/a")
	private WebElement pestanaUsuarios;

	public WebElement getCajaTextoEmail() {
		return cajaTextoEmail;
	}

	/**
	 * 
	 * @param cajaTextoEmail
	 */
	public void setCajaTextoEmail(WebElement cajaTextoEmail) {
		this.cajaTextoEmail = cajaTextoEmail;
	}

	public WebElement getBtncrearUsuario() {
		return btnCrearUsuario;
	}

	public void setBtncrearUsuario(WebElement btncrearUsuario) {
		this.btnCrearUsuario = btncrearUsuario;
	}

	public WebElement getCajatextoIdentificacion() {
		return cajatextoIdentificacion;
	}

	public void setCajatextoIdentificacion(WebElement cajatextoIdentificacion) {
		this.cajatextoIdentificacion = cajatextoIdentificacion;
	}

	public WebElement getCajatextoNombre() {
		return cajatextoNombre;
	}

	public void setCajatextoNombre(WebElement cajatextoNombre) {
		this.cajatextoNombre = cajatextoNombre;
	}

	public WebElement getComboBoxPerfil() {
		return comboBoxPerfil;
	}

	public void setComboBoxPerfil(WebElement comboBoxPerfil) {
		this.comboBoxPerfil = comboBoxPerfil;
	}

	public WebElement getComboBoxPerfil_1() {
		return comboBoxPerfil_1;
	}

	public void setComboBoxPerfil_1(WebElement comboBoxPerfil_1) {
		this.comboBoxPerfil_1 = comboBoxPerfil_1;
	}

	public WebElement getComboBoxPerfil_2() {
		return comboBoxPerfil_2;
	}

	public void setComboBoxPerfil_2(WebElement comboBoxPerfil_2) {
		this.comboBoxPerfil_2 = comboBoxPerfil_2;
	}

	public WebElement getComboBoxPerfil_3() {
		return comboBoxPerfil_3;
	}

	public void setComboBoxPerfil_3(WebElement comboBoxPerfil_3) {
		this.comboBoxPerfil_3 = comboBoxPerfil_3;
	}

	public WebElement getComboBoxPerfil_4() {
		return comboBoxPerfil_4;
	}

	public void setComboBoxPerfil_4(WebElement comboBoxPerfil_4) {
		this.comboBoxPerfil_4 = comboBoxPerfil_4;
	}

	public WebElement getComboBoxPerfil_5() {
		return comboBoxPerfil_5;
	}

	public void setComboBoxPerfil_5(WebElement comboBoxPerfil_5) {
		this.comboBoxPerfil_5 = comboBoxPerfil_5;
	}

	public WebElement getCajaTextoNombreUsuario() {
		return cajaTextoNombreUsuario;
	}

	public void setCajaTextoNombreUsuario(WebElement cajaTextoNombreUsuario) {
		this.cajaTextoNombreUsuario = cajaTextoNombreUsuario;
	}

	public WebElement getBtnGuardarUsuario() {
		return btnGuardarUsuario;
	}

	public void setBtnGuardarUsuario(WebElement btnGuardarUsuario) {
		this.btnGuardarUsuario = btnGuardarUsuario;
	}

	public WebElement getBtnAdministracion() {
		return btnAdministracion;
	}

	public void setBtnAdministracion(WebElement btnAdministracion) {
		this.btnAdministracion = btnAdministracion;
	}

	public WebElement getBtnUsuarios() {
		return btnUsuarios;
	}

	public void setBtnUsuarios(WebElement btnUsuarios) {
		this.btnUsuarios = btnUsuarios;
	}

	public WebElement getBtnCrearUsuario() {
		return btnCrearUsuario;
	}

	public void setBtnCrearUsuario(WebElement btnCrearUsuario) {
		this.btnCrearUsuario = btnCrearUsuario;
	}

	public WebElement getCajaTextoBuscador() {
		return cajaTextoBuscador;
	}

	public void setCajaTextoBuscador(WebElement cajaTextoBuscador) {
		this.cajaTextoBuscador = cajaTextoBuscador;
	}

	public WebElement getTextoIdRepetido() {
		return textoIdRepetido;
	}

	public void setTextoIdRepetido(WebElement textoIdRepetido) {
		this.textoIdRepetido = textoIdRepetido;
	}

	public WebElement getBtnBuscador() {
		return btnBuscador;
	}

	public void setBtnBuscador(WebElement btnBuscador) {
		this.btnBuscador = btnBuscador;
	}

}
