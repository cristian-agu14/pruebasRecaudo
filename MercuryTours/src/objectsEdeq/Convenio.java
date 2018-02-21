package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class Convenio extends PageBase {

	public Convenio(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	public boolean crearConvenioRecaudo(String numero, String nombre, String posInicioCodEmpresa,
			String posFinCodempresa, String posInicioReferencia, String posFinReferencia, String posInicioValor,
			String posFinValor, String posInicioFecha, String posfinFecha, String ip, String puerto, String ruta,
			String usuario, String contrasena, String cliente, String codigoEmpresa) {

		clickButtonLink(btnMenu);
		clickButtonLink(opcionRecaudo);
		clickButtonLink(pestanaConvenios);
		clickButtonLink(tipoConvenioCliente);
		// selectDropdownValue(listaClientes, cliente);
		sendText(numeroConvenioCajaTexto, numero);
		sendText(nombreConvenioCajaTexto, nombre);
		clickButtonLink(contenedorCodigoBarras);
		sendText(posIncioCodEmpresaCajaTexto, posInicioCodEmpresa);
		sendText(posFinCodEmpresaCajaTexto, posFinCodempresa);
		sendText(posInicioReferenciaCajaTexto, posInicioReferencia);
		sendText(posFinReferenciaCajaTexto, posFinReferencia);
		sendText(posInicioValorCajaTexto, posInicioValor);
		sendText(posFinValorCajaTexto, posFinValor);
		sendText(posinicioFechaCajaTexto, posInicioFecha);
		sendText(posFinalFechaCajaTexto, posfinFecha);
		sendText(codigoEmpresaCajaTexto, codigoEmpresa);
		clickButtonLink(contenedorFTP);
		sendText(ipCajaTexto, ip);
		sendText(puertoCajaTexto, puerto);
		sendText(rutaCajaTexto, ruta);
		sendText(usuarioCajaTexto, usuario);
		sendText(contrasenaCajaTexto, contrasena);
		esperar(8);
		clickButtonLink(btnSubirLogoCajaTexto);

		return true;
	}

	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/div/img")
	private WebElement btnMenu;

	@FindBy(how = How.ID, using = "menu2")
	private WebElement opcionRecaudo;

	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/ul/li[4]/a")
	private WebElement pestanaConvenios;

	@FindBy(how = How.ID, using = "cliente")
	private WebElement tipoConvenioCliente;

	@FindBy(how = How.ID, using = "clienteRecaudo")
	private WebElement listaClientes;

	@FindBy(how = How.ID, using = "proveedor")
	private WebElement tipoConvenioProveedor;

	@FindBy(how = How.ID, using = "ConvenioRecaudo_NUMERO_CONVENIO")
	private WebElement numeroConvenioCajaTexto;

	@FindBy(how = How.ID, using = "ConvenioRecaudo_NOMBRE")
	private WebElement nombreConvenioCajaTexto;

	@FindBy(how = How.ID, using = "formatoCodigoBarras_INICIAL_EMPRESA")
	private WebElement posIncioCodEmpresaCajaTexto;

	@FindBy(how = How.ID, using = "formatoCodigoBarras_FINAL_EMPRESA")
	private WebElement posFinCodEmpresaCajaTexto;

	@FindBy(how = How.ID, using = "formatoCodigoBarras_INICIAL_REFERENCIA")
	private WebElement posInicioReferenciaCajaTexto;

	@FindBy(how = How.ID, using = "formatoCodigoBarras_FINAL_REFERENCIA")
	private WebElement posFinReferenciaCajaTexto;

	@FindBy(how = How.ID, using = "formatoCodigoBarras_INICIAL_VALOR")
	private WebElement posInicioValorCajaTexto;

	@FindBy(how = How.ID, using = "formatoCodigoBarras_FINAL_VALOR")
	private WebElement posFinValorCajaTexto;

	@FindBy(how = How.ID, using = "formatoCodigoBarras_INICIAL_FECHA")
	private WebElement posinicioFechaCajaTexto;

	@FindBy(how = How.ID, using = "formatoCodigoBarras_FINAL_FECHA")
	private WebElement posFinalFechaCajaTexto;

	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[2]/div[2]/fieldset/div/form/div[3]/div[2]/div[3]/div[1]/div/label/span")
	private WebElement btnSubirLogoCajaTexto;

	@FindBy(how = How.ID, using = "ConvenioRecaudo_NIT")
	private WebElement codigoEmpresaCajaTexto;

	@FindBy(how = How.ID, using = "ftpURL")
	private WebElement ipCajaTexto;

	@FindBy(how = How.ID, using = "ftpPUERTO")
	private WebElement puertoCajaTexto;

	@FindBy(how = How.ID, using = "ftpRUTAINTERNA")
	private WebElement rutaCajaTexto;

	@FindBy(how = How.ID, using = "ftpUSUARIO")
	private WebElement usuarioCajaTexto;

	@FindBy(how = How.ID, using = "ftpCONTRASENA")
	private WebElement contrasenaCajaTexto;

	/**
	 * Parametro que representa el boton para terminar de guardar el cliente de
	 * recaudo
	 */
	@FindBy(how = How.ID, using = "grabar")
	private WebElement btnGrabarConvenioRecaudo;

	@FindBy(how = How.ID, using = "1")
	private WebElement contenedorCodigoBarras;

	@FindBy(how = How.ID, using = "4")
	private WebElement contenedorFTP;
}
