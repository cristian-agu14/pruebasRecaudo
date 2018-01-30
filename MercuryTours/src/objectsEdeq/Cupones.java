package objectsEdeq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class Cupones extends PageBase {

	public Cupones(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	/**
	 * Metodo que crea un cupon
	 * 
	 * @param nit
	 * @param nombreEmpresa
	 * @param numeroReferencia
	 * @param valorSAC
	 * @param codigoBarras
	 * @param valorCupon
	 * @return
	 */
	public boolean crearCupon(String nit, String nombreEmpresa, String numeroReferencia, String valorSAC,
			String codigoBarras, String valorCupon) {
		clickButtonLink(btnMenuPrincipal);
		clickButtonLink(opcionPagoObligacioes);
		sendText(nitCupon, nit);
		sendText(nombreempresa, nombreEmpresa);
		sendText(numeroInternoEmpresa, numeroReferencia);
		sendText(cajaTextoValorSAC, valorSAC);
		sendText(cajaTextoCodigoBarras, codigoBarras);
		sendText(cajaTextoValorCupon, valorCupon);
		clickButtonLink(btnGrabarCupon);

		return true;

	}
	
	//@FindBy(how = How.XPATH, using = "//html/body/div[2]/div[2]/div[1]/div/img")
	//@FindBy(how = How.CLASS_NAME, using="menuBtn")
	@FindBy(how = How.CSS, using="html body div.container-fluid div.row div.menuBar div.menuBtn img")
	private WebElement btnMenuPrincipal;

	@FindBy(how = How.ID, using = "menu14")
	private WebElement opcionPagoObligacioes;

	@FindBy(how = How.ID, using = "nitCupon")
	private WebElement nitCupon;

	@FindBy(how = How.ID, using = "NombreEmpresa")
	private WebElement nombreempresa;

	@FindBy(how = How.ID, using = "convenioRecaudo_CELULAR")
	private WebElement numeroInternoEmpresa;

	@FindBy(how = How.ID, using = "Devuelta")
	private WebElement cajaTextoValorSAC;
	
	@FindBy(how = How.ID, using = "CodigoBarrasCadena")
	private WebElement cajaTextoCodigoBarras;

	@FindBy(how = How.ID, using = "ValorCupon")
	private WebElement cajaTextoValorCupon;

	@FindBy(how = How.ID, using = "/html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/fieldset/div/div/div[1]/div[1]/div/form/div/div[3]/div/input")
	private WebElement btnGrabarCupon;

}
